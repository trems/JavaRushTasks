package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       // String url = "http://gamensnsobj.ns/delta/index.html?obj=343   .   9&name=Amigo&obj=3.22323";
        String url = reader.readLine();
        String params = "";
        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        ArrayList<String> alerts = new ArrayList<>();

        if (url.contains("?")) {
            params = url.substring(url.indexOf("?")+1);
            StringBuilder builder = new StringBuilder();
            boolean isObj = false;
            for (int i = 0; i < params.length(); i++) {

                if (params.charAt(i) != '=' && params.charAt(i) != '&') {
                    builder.append(params.charAt(i));
                } else if (params.charAt(i) == '=') {
                    if (!builder.toString().isEmpty()) keys.add(builder.toString());
                    isObj = isObj(builder);
                    builder.delete(0, builder.toString().length());
                } else if (params.charAt(i) == '&') {
                    if (params.charAt(i - (builder.toString().length())-1) == '&') {
                        if (!builder.toString().isEmpty()) keys.add(builder.toString());
                        isObj = isObj(builder);
                        builder.delete(0, builder.toString().length());
                    } else {
                        if (!builder.toString().isEmpty()) {
                            if (isObj) {
                                alerts.add(builder.toString());

                            }
                            values.add(builder.toString());
                            builder.delete(0, builder.toString().length());
                        }

                    }
                }
            }
            if (params.charAt(params.length() - (builder.toString().length())-1) == '=') {
                if (!builder.toString().isEmpty()) {
                    if (isObj) {
                        alerts.add(builder.toString());
                    }
                    values.add(builder.toString());
                }

            } else if (params.charAt(params.length() - (builder.toString().length())-1) == '&') {
                if (!builder.toString().isEmpty()) keys.add(builder.toString());
            }
        }

      //  System.out.println(params);
        if (alerts.size() != 0) {
            String keysStr = "";
            for (String s : keys) {
                keysStr += s + " ";
            }

            System.out.println(keysStr.trim());

            for (String s : alerts) {
                try {
                    alert(Double.parseDouble(s));
                } catch (NumberFormatException e) {
                    alert(s);
                }
            }
        } else {
            String keysStr = "";
            for (String s : keys) {
                keysStr += s + " ";
            }
            System.out.print(keysStr.trim());

        }



    }

    static boolean isObj(StringBuilder builder) {
        if (builder.toString().equals("obj")) {
            return true;
        } else return false;
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
