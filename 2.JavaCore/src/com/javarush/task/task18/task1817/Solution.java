package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(args[0]);
        int spaces = 0;
        int symbols = 0;
        double relation;

        int readByte;
        while (fis.available() > 0) {
            readByte = fis.read();
            if (readByte != 32) symbols++;
            else {
                spaces++;
                symbols++;
            }
        }
        relation = ((double) spaces / (double) symbols) * 100;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(df.format(relation));
        fis.close();

    }
}
