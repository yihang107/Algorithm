package com.yyh.Sort;

import java.util.Random;

public class Sort {
    // 选择排序
    public static int[] selectionSort(int[] origin){
        int[] sortedData = origin.clone();
        for (int i = 0; i < sortedData.length; i++){
            int minIndex = i;
            for (int j = i + 1; j < sortedData.length; j++){
                if (sortedData[i] > sortedData[j]) {
                    minIndex = j;
                }
                swap(sortedData, i, minIndex);
            }
        }

        return sortedData;
    }

    // 冒泡排序
    public static int[] bubbleSort(int[] origin){
        int[] sortedData = origin.clone();
        for (int i = 0; i < sortedData.length; i++){
            for (int j = i + 1; j < sortedData.length; j++){
                if (sortedData[i] > sortedData[j]) {
                    swap(sortedData, i, j);
                }
            }
        }

        return  sortedData;
    }


    // 归并排序
    public static int[] mergeSort(int[] origin){
        int[] sortedData = origin.clone();
        int[] tempData =origin.clone();
        mergeSort(sortedData, 0, sortedData.length - 1, tempData);
        return sortedData;
    }

    public static  void mergeSort(int[] sortedData, int head, int tail, int[] tempData){
        if (head == tail) {
            return;
        }

        mergeSort(sortedData, head, head + (tail - head)/2, tempData);
        mergeSort(sortedData, head + (tail - head)/2 + 1, tail, tempData);

        //merge
        int p1 = head;
        int middle = head + (tail - head)/2;
        int p2 = middle + 1;
        int mergeIndex = head;

        for (; mergeIndex <= tail; mergeIndex++) {
            if (p1 <= middle && p2 <= tail){
                if (sortedData[p1] < sortedData[p2]) {
                    tempData[mergeIndex] = sortedData[p1];
                    p1++;
                } else {
                    tempData[mergeIndex] = sortedData[p2];
                    p2++;
                }
            } else if (p1 <= middle && p2 > tail) {
                while (p1 <= middle){
                    tempData[mergeIndex] = sortedData[p1];
                    p1++;
                    mergeIndex++;
                }
            } else {
                while (p2 <= tail){
                    tempData[mergeIndex] = sortedData[p2];
                    p2++;
                    mergeIndex++;
                }
            }
        }

        for (int i = head; i <= tail; i++) {
            sortedData[i] = tempData[i];
        }
    }

    //快速排序
    public static int[]quickSort(int[] originalData) {
        int[] sortedData = originalData.clone();
        quickSortRecursion(sortedData, 0, sortedData.length - 1);
        return sortedData;
    }

    private  static  void quickSortRecursion(int[] sortedData, int head, int tail) {
        if (head == tail) {
            return;
        }

        int partitionIndex = head + new Random().nextInt(tail - head + 1);
        swap(sortedData, head, partitionIndex);
        int left = head + 1;
        int right = tail;
        while (left < right) {
            while ( (sortedData[left] <= sortedData[head]) && (left < right) ) {
                left ++;
            }

            while ( (sortedData[right] >= sortedData[head]) && (left < right)) {
                right --;
            }

            if (left < right) {
                swap(sortedData, left, right);
            }
        }

        if (sortedData[right] > sortedData[head]) {
            swap(sortedData, right - 1, head);
            partitionIndex = right - 1;
        } else {
            swap(sortedData, right, head);
            partitionIndex = right;
        }


        if (partitionIndex != head) {
            quickSortRecursion(sortedData, head, partitionIndex - 1);
        }
        if (partitionIndex != tail) {
            quickSortRecursion(sortedData, partitionIndex + 1, tail);
        }
    }

    private static void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
