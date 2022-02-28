package com.yyh.HanoiTower;

import java.util.ArrayList;

public class Tower {
    String name;
    ArrayList<Integer> nums;

    public Tower(String name, ArrayList<Integer> nums) {
        this.name = name;
        this.nums = new ArrayList<Integer>();
        for (int num : nums) {
            this.nums.add(num);
        }
    }

    public Tower(String name) {
        this.name = name;
        this.nums = new ArrayList<Integer>();
    }

    @Override
    public String toString() {
        return name + ": " + nums.toString();
    }

    public  boolean add(int num) {
        return  this.nums.add(num);
    }

    public int remove(){
        return this.nums.remove(nums.size() - 1);
    }

    public  int size() {
        return nums.size();
    }
}
