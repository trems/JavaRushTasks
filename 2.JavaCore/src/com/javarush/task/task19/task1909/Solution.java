package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(file1));

        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()) {
            sb.append(fileReader.readLine());
        }
        String result = sb.toString().replace('.', '!');
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));
        fileWriter.write(result);

        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
