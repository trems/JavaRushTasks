package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] bigArr = new int[20];

        for (int i = 0; i < 20; i++) {
            bigArr[i] = Integer.parseInt(br.readLine());
        }

        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int counter2 = 0;

        for (int i = 0; i < 20; i++) {
            if (i < 10) {
                arr1[i] = bigArr[i];
            }
            else {
                arr2[counter2] = bigArr[i];
                counter2++;
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(arr2[i]);
        }
    }
}
