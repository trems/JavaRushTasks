package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileOutputStream fos = new FileOutputStream(file2);

        ArrayList<Double> list1 = new ArrayList<>();
        FileInputStream fis = new FileInputStream(file1);
        StringBuilder sb = new StringBuilder();
        int readByte;
        while ((readByte = fis.read()) != -1) {
            if (readByte != 32) {
                sb.append( (char) readByte);
            } else {
                list1.add(Double.parseDouble(sb.toString()));
                sb = new StringBuilder();
            }
        }
        if (!sb.toString().isEmpty()) list1.add(Double.parseDouble(sb.toString()));

        DecimalFormat dfNegative = new DecimalFormat("#");
        DecimalFormat dfPositive = new DecimalFormat("#");
        dfPositive.setRoundingMode(RoundingMode.HALF_UP);
        dfNegative.setRoundingMode(RoundingMode.HALF_DOWN);

        sb = new StringBuilder();

        for (Double d : list1) {
            if (d > 0) {
                sb.append(dfPositive.format(d)).append(" ");
            } else sb.append(dfNegative.format(d)).append(" ");
        }
        String resultString = sb.toString();

        for (Character ch : resultString.toCharArray()) {
            fos.write( (int) ch);
        }
        fis.close();
        fos.close();
        reader.close();

    }
}
