package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        ArrayList<Integer> list1 = new ArrayList<>();
        int readByte;
        FileInputStream fis2 = new FileInputStream(file2);
        while (fis2.available() > 0) {
            readByte = fis2.read();
            list1.add(readByte);
        }
        FileInputStream fis1 = new FileInputStream(file1);
        while (fis1.available() > 0) {
            readByte = fis1.read();
            list1.add(readByte);
        }
        FileOutputStream fos1 = new FileOutputStream(file1);

        for (Integer i : list1) {
            fos1.write(i);
        }
        fis1.close();
        fis2.close();
        fos1.close();
        reader.close();

    }
}
