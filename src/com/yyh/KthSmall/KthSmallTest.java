package com.yyh.KthSmall;

public class KthSmallTest {
    public static void main(String argv[]){
        int[] array = {10, 6, 2, 8, 4, 3, 11, 5, 13};
        System.out.println("第2最小数(从0开始算)是" + KthSmall.getKthSmall(array, 2));
    }
}
