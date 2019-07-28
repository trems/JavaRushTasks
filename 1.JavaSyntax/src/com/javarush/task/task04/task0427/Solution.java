package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {

    static String isEven(int a) {
        if (a % 2 == 0)
            return "четное";
        else return "нечетное";
    }

    static String numOfDigits(String a) {
        if (a.length() == 1)
            return "однозначное";
        else if (a.length() == 2)
            return "двузначное";
        else if (a.length() == 3)
            return "трехзначное";
        else return "";

    }

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int num = Integer.parseInt(a);

        if (num > 0 && num < 1000)
            System.out.println(isEven(num)+" "+numOfDigits(a)+" число");

    }
}
