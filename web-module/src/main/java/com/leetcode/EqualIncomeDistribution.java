package com.leetcode;

import java.util.Arrays;
import java.util.Optional;

public class EqualIncomeDistribution {

    public static void main(String[] args) {
        System.out.println(" response ::" + Arrays.toString(distributeIncomeEqually(600d, new Double[]{100d, 200d, 400d})));
        System.out.println(" response ::" + Arrays.toString(distributeIncomeEqually(800d, new Double[]{100d, 100d, 800d})));
        System.out.println(" response ::" + Arrays.toString(distributeIncomeEqually(1000d, new Double[]{200d, 200d, 400d, 400d})));
        System.out.println(" response ::" + Arrays.toString(distributeIncomeEqually(1000d, new Double[]{200d, 200d, 300d, 400d})));
        System.out.println(" response ::" + Arrays.toString(distributeIncomeEqually(1000d, new Double[]{200d, 200d, 300d, 300d})));
        System.out.println(" response ::" + Arrays.toString(distributeIncomeEqually(1600d, new Double[]{200d, 200d, 300d, 300d})));

        // response ::[0.0, 0.0, 100.0]
        // response ::[0.0, 0.0, 199.99999999999986]
        // response ::[0.0, 0.0, 100.0, 100.0]
        // response ::[0.0, 0.0, 0.0, 100.0]
        // response ::[0.0, 0.0, 0.0, 0.0]
        // response ::[0.0, 0.0, 0.0, 0.0]
    }

    public static Double[] distributeIncomeEqually(final Double income, final Double[] lenders){
        if (lenders.length == 0) {
            return lenders;
        }
        //copy the input array
        final Double[] input = Arrays.copyOf(lenders, lenders.length);

        //First distribution
        final double equalAmt = income / lenders.length;
        for(int i =0; i < lenders.length; i++) {
            input[i] = input[i] - equalAmt;
        }

        //Re-visit all the array indices until there are no negative values.
        while (getNextOverPaidIndex(input).isPresent()) {
            int overPaidIndex = getNextOverPaidIndex(input).get();
            double reDistAmt = Math.abs(input[overPaidIndex]  / (getNonZeroIndexCount(input)-1));
            input[overPaidIndex] = 0d;
            for(int i =0; i < input.length ; i++) {
                if ((input[i] != 0d)) {
                    input[i] = input[i] - reDistAmt;
                }
            }
        }
        return input;
    }

    /**
     * Finds the index containing the first negative amount in the given array.
     *
     * @param lenders the input array consisting of lender amounts.
     * @return the index containing the first negative value.
     */
    private static Optional<Integer> getNextOverPaidIndex(Double[] lenders) {
        for (int i = 0; i < lenders.length; i++) {
            if (lenders[i] < 0d) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    private static int getNonZeroIndexCount(Double[] lenders) {
        return (int) Arrays.stream(lenders).filter(lender -> lender != 0).count();
    }
}
