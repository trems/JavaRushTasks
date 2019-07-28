package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[10];
        int[] len = new int[10];

        for (int i = 0; i < 10; i++) {
            str[i] = br.readLine();
            len[i] = str[i].length();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(len[i]);
        }
    }
}
