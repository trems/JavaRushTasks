package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream file2os = new FileOutputStream(file2);
        FileOutputStream file3os = new FileOutputStream(file3);

        int file2size;
        int file3size;
        int fisAvailable = fis.available();
        if (fisAvailable % 2 == 0) {
            file2size = fisAvailable / 2;
            file3size = fisAvailable / 2;
        } else {
            file2size = (fisAvailable / 2) + 1;
            file3size = fisAvailable - file2size;
        }
        int byteCounter = 0;
        while (fis.available() > 0) {
            if (byteCounter < file2size) {
                file2os.write(fis.read());
            } else file3os.write(fis.read());

            byteCounter++;
        }
        fis.close();
        file2os.close();
        file3os.close();

    }
}
