package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        HashMap<String, Cat> cats = new HashMap<>();
        for (int i = 1; i < 11; i++) {
            String catsName = i + "-cat";
            cats.put(catsName, new Cat(catsName));
        }
        return cats;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        HashSet<Cat> cats = new HashSet<>();
        for (HashMap.Entry<String, Cat> cat : map.entrySet()) {
            cats.add(cat.getValue());
        }
        return cats;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
