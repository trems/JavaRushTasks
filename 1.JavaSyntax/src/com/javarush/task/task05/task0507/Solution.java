package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int counter = 0;
        float input;
        float sum = 0;

        while (true) {
            input = Float.parseFloat(br.readLine());
            if (input == -1) {
                System.out.println(sum / counter);
                break;
            }
            sum += input;
            counter++;


        }
    }
}

