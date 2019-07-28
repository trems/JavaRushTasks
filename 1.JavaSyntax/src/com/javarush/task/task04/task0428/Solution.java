package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        for (int i = 1; i < 4; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0)
                count++;
        }
        System.out.println(count);

    }
}
