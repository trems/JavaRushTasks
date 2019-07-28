package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {

    static String isEven(int a) {
        if (a % 2 == 0)
            return "четное";
        else return "нечетное";
    }

    static String isPositive(int a) {
        if (a > 0)
            return "положительное";
        else if (a < 0)
            return "отрицательное";
        else return "ноль";
    }

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        if (a != 0)
            System.out.println(isPositive(a) + " " + isEven(a) + " " + "число");
        else System.out.println(isPositive(a));
    }
}
