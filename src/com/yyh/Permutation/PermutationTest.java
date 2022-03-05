package com.yyh.Permutation;

import java.util.List;

public class PermutationTest {
    public static void main(String argv[]){
        int[] nums = {1, 2, 3};
        List<int[]> perms = Permutation.permute(nums);
        for (int[] perm : perms) {
            for (int element : perm) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
