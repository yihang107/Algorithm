package com.yyh.HanoiTower;

public class HanoiSimple {
    public static void move(Tower a, Tower b, Tower c) {
        move(a.size(), a, b, c);
    }

    // 将n个盘从a 借助b 移动到 c
    private static  void  move(int n, Tower a, Tower b, Tower c){
        if (n == 1){
            System.out.println(a.toString() + "; " + b.toString() + "; "+ c.toString());
            int element = a.remove();
            c.add(element);
            System.out.println("move " + element +  " from " + a.name + " to " + c.name);
        } else {
            move(n - 1, a, c, b);
            move(1, a, b, c);
            move(n - 1, b, a, c);
        }
    }
}
