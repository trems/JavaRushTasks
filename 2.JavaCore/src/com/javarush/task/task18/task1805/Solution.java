package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream fis = new FileInputStream(filename);
        ArrayList<Integer> sorted = new ArrayList<>();
        int readByte;

        while (fis.available() > 0) {
            readByte = fis.read();
            if (!sorted.contains(readByte)) sorted.add(readByte);
        }
        fis.close();
        Collections.sort(sorted);
        for (Integer i : sorted) {
            System.out.print(i + " ");
        }
    }
}
