package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("eee");
        list.add("fsf");
        list.add("sfsfs");
        list.add("sfsf");
        System.out.println(list.size());
        for (String element : list) {
            System.out.println(element);
        }
    }
}
