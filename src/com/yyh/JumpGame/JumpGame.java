package com.yyh.JumpGame;

public class JumpGame {

    // 给定数组，每个元素代表你在该位置可以跳跃的最大长度 判断是否能够跳到最后一个位置
    public static boolean canJumpToLast(int[] nums) {
        return canJumpByRecursion(nums, nums.length - 1);
    }

    private static boolean canJumpByRecursion(int[] nums, int last) {
        if (last == 0) {
            return true;
        }

        for (int i = last - 1; i >= 0; i--) {
            if (canJumpByRecursion(nums, i) && nums[i] >= last - i) {
                return true;
            }
        }

        return false;
    }
}
