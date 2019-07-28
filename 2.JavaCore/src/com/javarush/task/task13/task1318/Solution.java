package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sourceFile = br.readLine();
        br.close();
        FileInputStream inputStream = new FileInputStream(sourceFile);
        int output;

        while (inputStream.available() > 0) {

            output = inputStream.read();
            char c = (char) output;
            System.out.print(c);

        }


        inputStream.close();
    }
}