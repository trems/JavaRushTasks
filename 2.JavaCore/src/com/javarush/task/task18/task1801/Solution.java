package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream fis = new FileInputStream(filename);

        int maxByte = 0;
        int readByte;
        while (fis.available() > 0) {
            readByte = fis.read();
            if (readByte > maxByte) {
                maxByte = readByte;
            }
        }
        fis.close();
        System.out.println(maxByte);


    }
}
