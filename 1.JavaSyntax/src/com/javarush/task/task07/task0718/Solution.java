package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(br.readLine());
        }

        for (int i = 1; i < 10; i++) {
            if (list.get(i).length() < list.get(i-1).length()) {
                System.out.println(i);
            }
        }
    }
}

