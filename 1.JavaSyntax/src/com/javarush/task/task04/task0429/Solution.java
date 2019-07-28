package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int positive = 0;
        int negative = 0;

        for(int i = 1; i < 4; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0)
                positive++;
            else if (num < 0)
                negative++;
        }

        System.out.println("количество отрицательных чисел: " + negative);
        System.out.println("количество положительных чисел: " + positive);

    }
}
