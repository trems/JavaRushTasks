package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfNums = Integer.parseInt(reader.readLine());
        int maximum = Integer.parseInt(reader.readLine());
        int counter = 1;
        int input;

        while (counter < numberOfNums) {
            input = Integer.parseInt(reader.readLine());
            maximum = maximum > input ? maximum : input;
            counter++;
        }

        //напишите тут ваш код

        System.out.println(maximum);
    }
}
