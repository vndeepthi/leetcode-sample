package com.leetcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThreadTest {

    AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        ThreadTest tt = new ThreadTest();
        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(() -> tt.count.addAndGet(1 )));

        stop(executor);

        System.out.println(tt.count);
    }

    public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
