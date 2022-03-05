package com.yyh.Traffic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class TrafficPlanner {
    public static LinkedList<LinkedList<String>> getTrafficGroups(HashMap<String, LinkedList<String>> traffic_conflict){
        LinkedList<LinkedList<String>> groups = new LinkedList<LinkedList<String>>();
        LinkedList<String> roadSet = new LinkedList<String>(traffic_conflict.keySet());
        while (roadSet.size() > 0){
            LinkedList<String> oneGroup = new LinkedList<String>();
            String road = roadSet.get(0);
            oneGroup.add(road);
            roadSet.remove(road);

            Iterator<String> roadSetIterator = roadSet.iterator();
            while (roadSetIterator.hasNext()) {
                String roadToAdd = roadSetIterator.next();
                if (checkNoConflict(roadToAdd, oneGroup, traffic_conflict)){
                    oneGroup.add(roadToAdd);
                    roadSetIterator.remove();
                }
            }

            groups.add(oneGroup);
        }

        // 对每一个分好的非冲突小组检查， 每一个加入的road检查其是否和 roads集合中的其他road冲突，没有则加入
        for (LinkedList<String> group : groups){
            for (String road : traffic_conflict.keySet()){
                if (checkNoConflict(road, group, traffic_conflict)){
                    group.add(road);
                }
            }
        }

        return groups;
    }

    private static boolean checkNoConflict(String roadToAdd, LinkedList<String>oneGroup, HashMap<String, LinkedList<String>> traffic_confict){
        for (String road : oneGroup) {
            if (traffic_confict.get(road).contains(roadToAdd) || roadToAdd == road){
                return false;
            }
        }

        return true;
    }
}
