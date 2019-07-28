package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String a = "";

        for (int i = 0; i < input.length(); i++) {
            a = String.valueOf(input.charAt(i));
            int b = Integer.parseInt(a);
            if (b % 2 == 0) {
                even++;
            } else odd++;

        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
