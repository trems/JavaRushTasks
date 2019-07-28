package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        if (args.length > 2) {
            try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw"))
            {
                long pos = Long.parseLong(args[1]);
                if (raf.length() >= pos) {
                    raf.seek(pos);
                } else raf.seek(raf.length());
                raf.write(args[2].getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
