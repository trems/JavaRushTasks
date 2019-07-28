package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
            StringBuilder sb = new StringBuilder();

            while (fileReader.ready()) {
                String line = fileReader.readLine();
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.length() > 6) {
                        sb.append(word).append(",");
                    }
                }

            }
            String result = sb.toString();
            result = result.substring(0, result.length()-1);
            fileWriter.write(result);
            fileReader.close();
            fileWriter.close();
        }

    }
}
