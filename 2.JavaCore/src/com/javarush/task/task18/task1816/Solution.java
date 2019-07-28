package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int sum = 0;
        int readByte;

        while (fis.available() > 0) {
            readByte = fis.read();
            if ((readByte > 64 && readByte < 91) || (readByte > 96 && readByte < 123)) {
                sum++;
            }
        }
        System.out.println(sum);
        fis.close();
    }
}
