package com.yyh.LCS;

public class LCS {
    // 只要求公共序列顺序相同，位置不要求
    public static String getLongestCommonSubsequence(String str1, String str2) {
        int rowNum = str1.length();
        int colNum = str2.length();
        int[][] table = new int[rowNum][colNum];
        table[0][0] = (str1.charAt(0) == str2.charAt(0)) ? 1 : 0;

        for (int i = 1; i < rowNum; i++) {
            table[i][0] = (str1.charAt(i) == str2.charAt(0)) ? 1 : 0;
        }

        for (int j = 1; j < colNum; j++) {
            table[0][j] = (str1.charAt(0) == str2.charAt(j) ? 1 : 0);
        }

        for (int i = 1; i < rowNum; i++) {
            for (int j = 1; j < colNum; j ++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        int i = rowNum - 1;
        int j = colNum - 1;
        String lcs = "";
        while(i != 0 && j != 0) {
            if (table[i - 1][j] == table[i][j]) {
                i--;
            } else if (table[i][j - 1] == table[i][j]) {
                j--;
            } else {
                lcs = str1.charAt(i) + lcs;
                i--;
                j--;
            }
            lcs = str1.charAt(i) + lcs;
        }

        return lcs;
    }
}
