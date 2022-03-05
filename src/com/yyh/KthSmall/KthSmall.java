package com.yyh.KthSmall;

import java.util.Random;

public class KthSmall {

    public static int getKthSmall(int[] data, int k){
        int[] sortedArray = data.clone();
        int kthSmall = kthSmallQuickSortRecursion(sortedArray, 0, data.length - 1, k);
        for (int i = 0; i < data.length; i ++){
            System.out.print(sortedArray[i] + " ");
        }
        return kthSmall;
    }

    public static int kthSmallQuickSortRecursion(int[] data, int head, int tail, int k){
        if (head == tail) {
            return data[head];
        }

        int partitionIndex = head + new Random().nextInt(tail - head + 1);
        swap(data, head, partitionIndex);
        int left = head + 1;
        int right = tail;
        while (left < right) {
            while (data[left] <= data[head] && left < right) {
                left++;
            }

            while (data[right] >= data[head] && left < right) {
                right--;
            }

            if (left < right) {
                swap(data, left, right);
            }
        }

        if (data[right] > data[head]) {
            swap(data, head, right - 1);
            partitionIndex = right - 1;
        } else {
            swap(data, head, right);
            partitionIndex = right;
        }

        if (partitionIndex == k) {
            return data[partitionIndex];
        } else if (partitionIndex < k) {
            return kthSmallQuickSortRecursion(data, partitionIndex + 1, tail, k);
        } else {
            return kthSmallQuickSortRecursion(data, head, partitionIndex - 1, k);
        }
    }

    public static void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
