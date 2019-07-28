package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream fis = new FileInputStream(filename);
        int sum = 0;


        while (fis.available() > 0) {
            if (fis.read() == 44) sum++;
        }
        System.out.println(sum);
        fis.close();
    }
}
