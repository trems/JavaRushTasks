package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        double t = Double.parseDouble(bf.readLine());
        double modT = t % 5;

            if(modT < 3 && modT >= 0)
                System.out.println("зелёный");
            else if(modT >= 3 && modT < 4)
                System.out.println("жёлтый");
            else System.out.println("красный");
        }

    }
