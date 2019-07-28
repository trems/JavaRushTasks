package com.javarush.task.task22.task2203;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String result;
        try {
            Pattern p = Pattern.compile("\\t(?<res>[^\\t]+)\\t");
            Matcher m = p.matcher(string);
            if (m.find()) {
                result = m.group("res");
                //result = result.replaceAll("\\t", "");
                return result;
            }
            else throw new TooShortStringException();
        } catch (Exception e) {
            throw new TooShortStringException();
        }

    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
