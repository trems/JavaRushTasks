package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(bf.readLine());
        String msg = "количество дней в году: ";

        if(year % 400  == 0)
            System.out.println(msg+366);
        else if(year % 400 != 0 && year % 100 == 0)
            System.out.println(msg+365);
        else if(year % 4 == 0)
            System.out.println(msg+366);
        else System.out.println(msg+365);
    }
}