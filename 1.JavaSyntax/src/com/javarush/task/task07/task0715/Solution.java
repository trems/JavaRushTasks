package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> abc = new ArrayList<>();
        abc.add("мама");
        abc.add("мыла");
        abc.add("раму");

        for (int i = 0; i < 3; i++) {
            abc.add(i+i+1, "именно");
        }
        for (String str : abc) {
            System.out.println(str);
        }
    }
}
