package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("luke", df.parse("DECEMBER 23 1980"));
        map.put("michele", df.parse("OCTOBER 2 1980"));
        map.put("afaf", df.parse("JANUARY 21 1980"));
        map.put("enre", df.parse("JULY 4 1980"));
        map.put("rgsr", df.parse("SEPTEMBER 6 1980"));
        map.put("kssf", df.parse("JUNE 9 1980"));
        map.put("vsd", df.parse("AUGUST 3 1980"));
        map.put("qwsdfg", df.parse("NOVEMBER 3 1980"));
        map.put("edem", df.parse("MARCH 8 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<HashMap.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<String, Date> entry = iterator.next();
            if (entry.getValue().getMonth() > 4 && entry.getValue().getMonth() < 8) {
                iterator.remove();
            }
        }

    }

    public static void main(String[] args) throws ParseException {

    }
}

