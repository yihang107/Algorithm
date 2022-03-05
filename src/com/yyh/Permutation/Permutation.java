package com.yyh.Permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public  static List<int[]> permute(int nums[]){
        List<int[]> perms = new ArrayList<>();
        permute_recursion(nums, 0 , perms);
        return perms;
    }

    private  static  void permute_recursion(int[] nums, int start_index, List<int[]> list){
        int n = nums.length;
        if (start_index == n-1) {
            int[] perm = new int[n];
            for (int i = 0; i < n; i++) {
                perm[i] = nums[i];
            }
            list.add(perm);
        } else {
            for (int i = start_index; i < n; i++){
                swap(nums, start_index, i);
                permute_recursion(nums, start_index + 1, list);
                swap(nums, start_index, i);
            }
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
