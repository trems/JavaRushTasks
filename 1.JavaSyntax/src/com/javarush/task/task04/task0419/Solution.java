package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static int min(int a, int b) {
        if (a > b)
            return a;
        else return b;
    }
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        if (min(a, b) > min(c, d))
            System.out.println(min(a, b));
        else System.out.println(min(c, d));

    }
}
