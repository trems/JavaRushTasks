package com.javarush.task.task04.task0443;


/* 
Как назвали, так назвали
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        int y = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());

        System.out.println("Меня зовут " + name + ".");
        System.out.println("Я родился " + d + "." + m + "." + y);
    }
}
