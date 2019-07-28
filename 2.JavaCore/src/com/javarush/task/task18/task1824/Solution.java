package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = "";
        ArrayList<FileInputStream> fisList = new ArrayList<>();
        try {
            while (true) {
                filename = reader.readLine();
                fisList.add(new FileInputStream(filename));
            }
        } catch (FileNotFoundException e) {
            System.out.println(filename);
            for (FileInputStream fis : fisList) {
                fis.close();
            }

        }
    }
}
