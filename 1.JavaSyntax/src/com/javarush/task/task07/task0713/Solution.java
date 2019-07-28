package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> general = new ArrayList<>();
        ArrayList<Integer> three = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        ArrayList<Integer> rest = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            int input = Integer.parseInt(br.readLine());
            general.add(input);
            if (input % 3 == 0 && input % 2 == 0) {
                three.add(input);
                two.add(input);
            } else if (input % 3 == 0) three.add(input);
            else if (input % 2 == 0) two.add(input);
            else rest.add(input);
        }
        printList(three);
        printList(two);
        printList(rest);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (Integer e : list) {
            System.out.println(e);
        }
    }

}
