package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String targetId = args[0];
        String filename = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(filename));

        String readStr;
        while (fileReader.ready()) {
            readStr = fileReader.readLine();
            if (readStr.split(" ")[0].equals(targetId)) {
                System.out.println(readStr);
            }

        }
        reader.close();
        fileReader.close();
    }
}
