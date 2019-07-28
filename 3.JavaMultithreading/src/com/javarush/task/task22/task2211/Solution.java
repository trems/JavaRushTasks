package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            Charset windows1251 = Charset.forName("Windows-1251");
            Charset utf8 = Charset.forName("UTF-8");

            try (FileInputStream fis = new FileInputStream(args[0]);
                 FileOutputStream fos = new FileOutputStream(args[1]))
            {
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                String content = new String(buffer, windows1251);
                buffer = content.getBytes(utf8);
                fos.write(buffer);
            }



//            byte[] buffer = new byte[fis.available()];
//            ArrayList<Byte> list = new ArrayList<>();
//            String input = new String(buffer, windows1251);
//            while (fis.available() > 0) {
//                fis.read(buffer);
//            }

        }
    }
}
