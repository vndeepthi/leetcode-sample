package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LLClass<T> {
    LLNode<T> head;

    public LLClass(){
        this.head = null;
    }

    public void add (LLNode<T> node) {
        if (head == null) {
            head = node;
        } else {
            LLNode<T> x = head;
            while(x.next != null){
                x = x.next;
            }
            x.next = node;
        }
    }

    public void reverse(){
        LLNode<T> x = head;
        LLNode<T> prev = null;
        while(x.next != null){
            LLNode<T> nextNode = x.next;
            x.next = prev;
            prev = x;
            x = x.next;
        }
    }
}

class LLNode<T>{
    T value;
    LLNode<T> next;

    public LLNode(T val){
        this.value = val;
    }
}
