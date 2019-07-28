package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();

    }

    public static int readInt() throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    public static double readDouble() throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(br.readLine());
    }

    public static boolean readBoolean() throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Boolean.parseBoolean(br.readLine());

    }

    public static void main(String[] args) {

    }
}
