package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFile = consoleReader.readLine();
//        FileInputStream fileInput = new FileInputStream(sourceFile);
//        BufferedReader fileReader = new BufferedReader(new FileReader(sourceFile));
        Scanner in = new Scanner(new FileInputStream(sourceFile));

        ArrayList<Integer> list = new ArrayList<>();
        while (in.hasNext()) {

            list.add(Integer.parseInt(in.nextLine().trim()));
        }

        in.close();


        Collections.sort(list);

        for (Integer item : list) {
            if (item % 2 == 0) System.out.println(item);
        }
    }
}
