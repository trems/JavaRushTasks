package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String outPath = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(outPath));
        //writer.write(outPath);

        String input;
        while (true) {

            input = reader.readLine();
            writer.write(input);
            writer.newLine();
            if (input.equals("exit")) break;
        }
        reader.close();
        writer.close();

    }
}
