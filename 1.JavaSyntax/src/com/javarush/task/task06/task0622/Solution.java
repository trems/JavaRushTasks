package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < nums.length; i++) {
            int temp;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
