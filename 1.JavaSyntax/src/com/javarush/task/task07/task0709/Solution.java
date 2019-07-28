package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        int minStr = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            strings.add(input);
        }
        minStr = strings.get(0).length();

        for (String str : strings) {

            if(str.length() < minStr) {
                minStr = str.length();
            }
        }
        for(String str : strings) {
            if (str.length() == minStr) {
                System.out.println(str);
            }
        }
    }
}
