package com.yyh.Fibonacci;

public class Fibonacci {
    public static  long getByRecursion(long n) {
        if (n == 1 || n == 0){
            return n;
        }

        return getByRecursion(n - 1) + getByRecursion(n - 2);
    }

    public static long getByIteration(long n){
        if (n == 1 || n == 0){
            return n;
        }
        long a = 0, b = 1;
        for (long i = 2; i <= n; i++){
            long temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }

    public static int getByDevideConque(int n){
        int length = n + 1;
        int[] array = new int[length];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++){
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}
