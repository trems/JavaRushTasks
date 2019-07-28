package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] houses = new int[15];
        int even = 0;
        int odd = 0;
        for (int i = 0; i < 15; i++) {
            houses[i] = Integer.parseInt(br.readLine());
            if (i == 0 || i % 2 == 0) {
                even += houses[i];
            } else odd += houses[i];
        }
        if (odd > even) System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else System.out.println("В домах с четными номерами проживает больше жителей.");
    }
}
