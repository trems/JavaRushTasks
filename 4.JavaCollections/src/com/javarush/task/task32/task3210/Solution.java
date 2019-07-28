package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        if (args.length > 2) {
            try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw"))
            {
                long len = raf.length();
                int pos = Integer.parseInt(args[1]);
                String text = args[2];

                byte[] buf = new byte[text.length()];
                raf.seek(pos);
                raf.read(buf, 0, buf.length);
                String readStr = new String(buf);

                raf.seek(len);
                if (text.equals(readStr)) raf.write("true".getBytes());
                else raf.write("false".getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
