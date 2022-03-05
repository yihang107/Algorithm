package com.yyh.Sort;

public class SortTest {
    public static void main(String argv[]) {
        int[] data = {1, 3, 2, 5, 4};
        for (int i = 0; i < data.length; i++) {
            System.out.print(Sort.bubbleSort(data)[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.print(Sort.selectionSort(data)[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.print(Sort.mergeSort(data)[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.print(Sort.quickSort(data)[i] + " ");
        }
        System.out.println();
    }
}
