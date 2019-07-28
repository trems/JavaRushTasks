package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                s =s.substring(0, i+1) + s.substring(i+1, i+2).toUpperCase() + s.substring(i+2);
            }
        }
        System.out.println(s);
    }
}
