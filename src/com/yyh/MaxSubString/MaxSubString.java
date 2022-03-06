package com.yyh.MaxSubString;

public class MaxSubString {
    public static int[] getMaxSubString(int []price){
        int[] changes = new int[price.length - 1];

        int start = 0;
        int end = 0;
        int currentMaxSum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int[] result = {start, end, Integer.MIN_VALUE};

        // changes[i]  表示第i天买， 第i + 1天 卖
        for (int i = 0; i < changes.length; i++) {
            changes[i] = price[i + 1] - price[i];
            if ( i == 0) {
                currentMaxSum = changes[i];
                maxSum = changes[i];
            } else {
                if (currentMaxSum <= 0) {
                    currentMaxSum = changes[i];
                    start = i;
                } else {
                    currentMaxSum += changes[i];
                }

                if (currentMaxSum > maxSum) {
                    maxSum = currentMaxSum;
                    end = i + 1;
                }
            }
        }

        result = new int[]{start, end, maxSum};
        System.out.println("\n日期");
        for (int i = 0; i < price.length; i++) {
            System.out.printf("%7d", i);
        }
        System.out.println("\n原始价位");
        for (int i = 0; i < price.length; i++) {
            System.out.printf("%7d", price[i]);
        }

        //print
        System.out.println("\n每日收入");
        for (int i = 0; i < price.length; i++) {
            if (i == 0) {
                System.out.printf("%7d", i);
            } else {
                System.out.printf("%7d", changes[i - 1]);
            }
        }


        System.out.println("\n应该在第" + result[0] + "开始买，第" + result[1] + "天开始卖，一共挣钱" + result[2] );
        return result;
    }
}
