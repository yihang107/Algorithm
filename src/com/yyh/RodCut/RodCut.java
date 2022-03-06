package com.yyh.RodCut;

public class RodCut {
    public static int getMaxValueForRod(int[] rodPrice, int rodLength){
        int[] bestValue = new int[rodLength];
        int[] singlePrice = new int[rodPrice.length];
        for (int i = 0; i < rodLength; i++) {
            singlePrice[i] = rodPrice[i] / (i + 1);
            if (i == 0) {
                bestValue[i] = rodPrice[i];
            } else {
                if (i < rodPrice.length) {
                    bestValue[i] = singlePrice[i];
                } else {
                    bestValue[i] = Integer.MIN_VALUE;
                }
                int left = 0;
                int right = i - 1;
                while (left <= right) {
                    bestValue[i] =  Math.max(bestValue[left] + bestValue[right], bestValue[i]);
                    left++;
                    right--;
                }
            }
        }

        return bestValue[rodLength - 1];
    }
}
