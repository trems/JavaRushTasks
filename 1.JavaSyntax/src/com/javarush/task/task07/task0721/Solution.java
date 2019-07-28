package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
        int[] nums = new int[20];
        for (int i = 0; i < 20; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }
        maximum = nums[0];
        minimum = nums[0];
        for (int num : nums) {
            if (num > maximum) {
                maximum = num;
            }
            if (num < minimum) {
                minimum = num;
            }
        }

        System.out.print(maximum + " " + minimum);
    }
}
