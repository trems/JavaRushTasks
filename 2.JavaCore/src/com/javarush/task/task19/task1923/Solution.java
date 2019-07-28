package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length > 0) {

            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

            String currentLine;
            StringBuilder sb = new StringBuilder();
            while (fileReader.ready()) {
                currentLine = fileReader.readLine();
                sb.append(currentLine);
            }
            currentLine = null;
            String[] words = sb.toString().split("\\s+");
            for (String word : words) {
                if (word.matches(".*\\d.*")) {
                    fileWriter.write(word + " ");
                }
            }
            fileReader.close();
            fileWriter.close();

        }

    }
}
