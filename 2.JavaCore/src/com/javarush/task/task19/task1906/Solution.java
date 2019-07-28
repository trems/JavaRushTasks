package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        int counter = 0;
        int readByte;

        while (fileReader.ready()) {
            readByte = fileReader.read();
            counter++;
            if (counter % 2 == 0) {
                fileWriter.write(readByte);
            }
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
