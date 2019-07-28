package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename;
        BufferedReader fileReader = null;
        TreeMap<Integer, String> files = new TreeMap<>();
        String[] splittedFilename = new String[1];
        int filePart;

        while (true) {
            filename = reader.readLine();
            if (filename.equals("end")) break;
            splittedFilename = filename.split("\\.");
            filePart = Integer.parseInt(splittedFilename[splittedFilename.length-1].substring(4));
            files.put(filePart, filename); // записываем файлнеймы в нужном порядке
        }

        // получаем имя конечного файла
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splittedFilename.length-1; i++) {
            if (i != splittedFilename.length-2) {
                sb.append(splittedFilename[i]);
                sb.append(".");
            } else sb.append(splittedFilename[i]);
        }
        String outputFile = sb.toString();
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFile, true));

        for (Map.Entry<Integer, String> entry : files.entrySet()) {
            fileReader = new BufferedReader(new FileReader(entry.getValue()));
            while (fileReader.ready()) {
                fileWriter.write(fileReader.readLine());
            }
            fileReader.close();
        }

        fileWriter.close();
        reader.close();


    }
}
