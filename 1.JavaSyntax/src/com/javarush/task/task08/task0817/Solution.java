package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    static ArrayList<String> duplicatedValues = new ArrayList<>();

    public static HashMap<String, String> createMap() {
        //напишите тут ваш код

        HashMap<String, String> map = new HashMap<>();
        map.put("sfd", "qas");
        map.put("fsf", "czdxx");
        map.put("fsfsfsf", "qas");
        map.put("jjfb", "ccvdfv");
        map.put("bfb", "qas");
        map.put(",oj", "ngngh");
        map.put("sefs", "qwer");
        map.put("dvd", "reyryr");
        map.put("wdazz", "reyryr");
        map.put("vdvzvsv", "qwer");

        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        Iterator<HashMap.Entry<String, String>> iterator1 = map.entrySet().iterator();
        HashMap.Entry<String, String> entry1;
        HashMap.Entry<String, String> entry2;


        while (iterator1.hasNext()) {
            entry1 = iterator1.next();
            Iterator<HashMap.Entry<String, String>> iterator2 = map.entrySet().iterator();
            while (iterator2.hasNext()) {
                entry2 = iterator2.next();
                if (!entry2.getKey().equals(entry1.getKey()) &&
                        entry2.getValue().equals(entry1.getValue())) {

                    duplicatedValues.add(entry2.getValue());
                }
            }
        }

        for (String value : duplicatedValues) {
            removeItemFromMapByValue(map, value);
        }
    }


        public static void removeItemFromMapByValue (Map < String, String > map, String value){
            HashMap<String, String> copy = new HashMap<String, String>(map);
            for (Map.Entry<String, String> pair : copy.entrySet()) {
                if (pair.getValue().equals(value))
                    map.remove(pair.getKey());
            }
        }

        public static void main (String[]args){

        }
}

