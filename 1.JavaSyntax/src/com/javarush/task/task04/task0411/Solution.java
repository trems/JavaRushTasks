package com.javarush.task.task04.task0411;

/* 
Времена года на Терре
*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {
        //напишите тут ваш код
        String monthString;
        switch (month) {
            case 12:
            case 1:
            case 2:
                monthString = "зима";
                break;
            case 3:
            case 4:
            case 5:
                monthString = "весна";
                break;
            case 6:
            case 7:
            case 8:
                monthString = "лето";
                break;
            case 9:
            case 10:
            case 11:
                monthString = "осень";
                break;
            default:
                monthString = "Неверный месяц";
                break;
        }

        System.out.println(monthString);

    }
}