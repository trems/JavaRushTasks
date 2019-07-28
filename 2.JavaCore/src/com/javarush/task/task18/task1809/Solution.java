package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        ArrayList<Integer> list = new ArrayList<>(fis.available());
        while (fis.available() > 0) {
            list.add(fis.read());
        }
        for (int i = list.size()-1; i >= 0; i--) {
            fos.write(list.get(i));
        }
        fis.close();
        fos.close();
    }
}
