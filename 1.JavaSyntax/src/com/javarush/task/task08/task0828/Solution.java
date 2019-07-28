package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> months = new ArrayList<>(12);
        for (int i = 1; i < 13; i++) {
            months.add(Month.of(i).getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        }
        String monthName = br.readLine();
        for (int i = 0; i < 12; i++) {
            if (monthName.equals(months.get(i))) {
                System.out.println(monthName + " is the " + (i+1) + " month");
            }
        }

    }
}
