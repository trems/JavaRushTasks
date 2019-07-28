package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("роза");// 0
        list.add("мера");
        list.add("вода");
        list.add("лира"); // 1
        list.add("лоза"); // 2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        //напишите тут ваш код
        ArrayList<String> newList = new ArrayList<>();
        for (String s : list) {
            if (s.contains("р") && s.contains("л")) {
                newList.add(s);
            } else if (s.contains("л") && !s.contains("р")) {
                newList.add(s);
                newList.add(s);
            } else if (!s.contains("р") && !s.contains("л")) {
                newList.add(s);
            }
        }
        list = newList;
        return list;
    }
}