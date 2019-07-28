package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    static int x;
    static int y;
    static int z;

    static void max(int a, int b, int c) {

        if (a >= b && a >= c) {
            x = a;
            if (b >= c) {
                y = b;
                z = c;
            }
            else {
                y = c;
                z = b;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        max(a, b, c);
        max(a, c, b);
        max(b, a, c);
        max(b, c, a);
        max(c, a, b);
        max(c, b, a);

        System.out.println(x+" "+y+" "+z);



    }

}
