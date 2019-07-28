package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put("" + i, " " +i);
        }
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int counter = 0;
        for (HashMap.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue().equals(name)) {
                counter++;
            }
        }
        return counter;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int counter = 0;
        for (HashMap.Entry<String, String> pair : map.entrySet()) {
            if (pair.getKey().equals(lastName)) {
                counter++;
            }
        }
        return counter;

    }

    public static void main(String[] args) {

    }
}
