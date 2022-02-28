package com.yyh.HanoiTower;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(4);
        nums.add(3);
        nums.add(2);
        nums.add(1);

        Tower a = new Tower("A", nums);
        Tower b = new Tower("B");
        Tower c = new Tower("C");

        System.out.println(a.toString() + ";" + b.toString() + ";" + c.toString());
        HanoiSimple.move(a, b, c);
        System.out.println(a.toString() + ";" + b.toString() + ";" + c.toString());
    }
}
