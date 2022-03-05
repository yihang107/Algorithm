package com.yyh.Traffic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class TrafficTest {
    public static void main(String argv[]){
        HashMap<String, LinkedList<String>> traffic_conflict = new HashMap<String, LinkedList<String>>();
        traffic_conflict.put("AB", new LinkedList<String>(Arrays.asList("BC", "BD", "DA", "EA")));
        traffic_conflict.put("AC", new LinkedList<String>(Arrays.asList("BD", "DA", "DB", "EA", "EB")));
        traffic_conflict.put("AD", new LinkedList<String>(Arrays.asList("EA", "EB", "EC")));
        traffic_conflict.put("BA", new LinkedList<String>());
        traffic_conflict.put("BC", new LinkedList<String>(Arrays.asList("AB", "DB", "EB")));

        System.out.println(TrafficPlanner.getTrafficGroups(traffic_conflict));
    }
}
