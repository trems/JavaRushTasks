package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();

        map.put("fsdfnghn", 234);
        map.put("fsdf", 678);
        map.put("dsfsd", 5435);
        map.put("dfd", 224);
        map.put("jgg", 632);
        map.put("nhghg", 123);
        map.put("hgnh", 453);
        map.put("yhy", 789);
        map.put("hng", 900);
        map.put("hgnhn", 1887776);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<HashMap.Entry<String, Integer>> iterator = map.entrySet().iterator();
        HashMap.Entry<String, Integer> entry;

        while (iterator.hasNext()) {
            entry = iterator.next();
            if (entry.getValue() < 500) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}