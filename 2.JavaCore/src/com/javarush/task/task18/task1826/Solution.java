package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        switch (args[0]) {
            case "-e":
                encryptFile(args[1], args[2]);
                break;
            case "-d":
                decryptFile(args[1], args[2]);
                break;
        }


    }

    public static void encryptFile(String inputFile, String outputFile) throws IOException {
        FileInputStream fis = new FileInputStream(inputFile);
        FileOutputStream fos = new FileOutputStream(outputFile);
        int readByte;
        int writeByte;
        while (fis.available() > 0) {
            readByte = fis.read();
            writeByte = readByte +1;
            fos.write(writeByte);
        }
        fis.close();
        fos.close();
    }
    public static void decryptFile(String inputFile, String outputFile) throws IOException {
        FileInputStream fis = new FileInputStream(inputFile);
        FileOutputStream fos = new FileOutputStream(outputFile);
        int readByte;
        int writeByte;
        while (fis.available() > 0) {
            readByte = fis.read();
            writeByte = readByte-1;
            fos.write(writeByte);
        }
        fis.close();
        fos.close();
    }
}
