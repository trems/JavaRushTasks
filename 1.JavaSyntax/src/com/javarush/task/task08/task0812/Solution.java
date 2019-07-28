package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxCons = 1;
        int currentCons = 1;

        for (int i = 0; i < 10; i++) {
            int input = Integer.parseInt(br.readLine());
            list.add(input);
        }

        for (int i = 0; i < 9; i++) {
            if (list.get(i).equals(list.get(i+1))) {
                currentCons++;
                if (currentCons > maxCons) {
                    maxCons = currentCons;
                }
            } else {

                currentCons = 1;

            }


        }
        System.out.println(maxCons);

    }
}