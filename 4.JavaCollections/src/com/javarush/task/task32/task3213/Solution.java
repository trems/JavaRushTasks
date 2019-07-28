package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        int b;
        StringBuilder sb = new StringBuilder();
        try {
            while ((b = reader.read()) != -1 ) {
                sb.append( (char) (b+key));
            }
        } catch (NullPointerException e) {
            return sb.toString();
        }

        return sb.toString();
    }
}
