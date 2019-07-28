package com.javarush.task.task22.task2202;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString(null));
    }

    public static String getPartOfString(String string) {
        String result = null;
        //Pattern pattern = Pattern.compile("[\\s](?<res>[\\S]+[\\s][\\S]+[\\s][\\S]+[\\s][\\S]+)[\\s]");
        try {
            Pattern pattern = Pattern.compile("\\s(?<res>\\S+\\s\\S+\\s\\S+\\s\\S+)");
            Matcher m = pattern.matcher(string);
            if (m.find()) result = m.group("res");
            else throw new TooShortStringException();
        } catch (Exception e) {
            throw new TooShortStringException();
        }

        return result;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
