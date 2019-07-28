package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream fis = new FileInputStream(filename);

        int minByte = 127;
        int readByte;
        while (fis.available() > 0) {
            readByte = fis.read();
            if (readByte < minByte) {
                minByte = readByte;
            }
        }
        fis.close();
        System.out.println(minByte);

    }
}
