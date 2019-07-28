package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("city", "lange");
//        map.put("fgdfg", "fvdfv");
//        map.put("age", null);
//        map.put("str", "null");
//
//        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        String result;
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null && pair.getValue() != "null") {
                sb.append(String.format("%s = '%s' and ", pair.getKey(), pair.getValue()));
            }
        }
        result = sb.toString().replaceAll(" and $", "");
        return result;
    }
}
