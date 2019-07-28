package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int res = 0;

        if ((a > b && a < c) || (a > c && a < b))
            res = a;
        else if ((b > a && b < c) || (b > c && b < a))
            res = b;
        else if ((c > b && c < a) || (c > a && c < b))
            res = c;
        else if (a == b || a == c)
            res = a;
        else if (c == b)
            res = c;

        System.out.println(res);


    }
}
