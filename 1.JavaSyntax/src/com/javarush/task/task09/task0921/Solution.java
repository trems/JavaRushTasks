package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData(){
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int input;
            while (true) {
                input = Integer.parseInt(br.readLine());
                list.add(input);
            }

        } catch (NumberFormatException e) {
            for (Integer element : list) {
                System.out.println(element);
            }
        }
        catch (IOException e) {
            for (Integer element : list) {
                System.out.println(element);
            }
        }


    }
}
