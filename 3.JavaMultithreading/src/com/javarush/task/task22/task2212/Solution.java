package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.length() < 10) return false;
        telNumber = telNumber.trim();
        if (telNumber.matches("^\\+\\(?[0-9]{3}\\)?[0-9]{12}$")) return true;
        if (telNumber.matches("^\\+[0-9]{1,3}\\(?[0-9]{3}\\)?[0-9]{7}$")) return true;
        if (telNumber.matches("^\\+?\\d+\\-?\\d+\\-?\\d+$")) return true;
        return false;
    }

    public static void main(String[] args) {
        String[] arr = {"+380501234567",                   // true
                        "+38(050)1234567",                 // true
                        "+38050123-45-67",                 // true
                        "050123-4567",                     // true
                        "+38)050(1234567",                 // false
                        "+38(050)1-23-45-6-7",             // false
                        "050ххх4567",                      // false
                        "050123456",                       // false
                        "(0)501234567}" };                 // false

        for (String s : arr) {
            System.out.println(checkTelNumber(s));
        }

    }
}
