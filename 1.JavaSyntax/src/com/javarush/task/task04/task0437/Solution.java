package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        for (int i = 1; i <=10; i++){
            int a = 1;
            while (a <= i) {
                System.out.print(8);
                a++;
            }
            System.out.println();
        }

    }
}
