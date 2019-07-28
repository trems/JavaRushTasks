package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> peoples = new HashMap<>();
        peoples.put("bobrov", "ivan");
        peoples.put("ivanov", "vasya");
        peoples.put("strelkov", "igor");
        peoples.put("bobrov", "OLGA");
        peoples.put("fafs", "misha");
        peoples.put("fdsf", "igor");
        peoples.put("sfdf", "alex");
        peoples.put("fsdfs", "vasya");
        peoples.put("dfsd", "oleg");
        peoples.put("ivanov", "serj");

        return peoples;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
