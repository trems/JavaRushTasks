package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
        System.out.println(isDateOdd("JANUARY 1 2019"));
    }

    public static boolean isDateOdd(String date) {
        date = date.substring(0,1) + date.substring(1).toLowerCase();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH);
        LocalDate localDate = LocalDate.parse(date, dtf);
        int dayOfYear = localDate.getDayOfYear();
        if (dayOfYear % 2 != 0) {
            return true;
        } else return false;

    }
}
