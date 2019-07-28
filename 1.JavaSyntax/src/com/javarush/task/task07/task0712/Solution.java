package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            strings.add(br.readLine());
        }

        int maxChars = strings.get(0).length();
        int minChars = strings.get(0).length();

        for (String str : strings) {
            if (str.length() < minChars) minChars = str.length();
            else if (str.length() > maxChars) maxChars = str.length();
        }
        for (String str : strings) {
            if (str.length() == minChars || str.length() == maxChars) {
                System.out.println(str);
                break;
            }
        }
    }
}
