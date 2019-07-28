package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashSet<String> veggies = new HashSet<>();

        veggies.add("арбуз");
        veggies.add("банан");
        veggies.add("вишня");
        veggies.add("груша");
        veggies.add("дыня");
        veggies.add("ежевика");
        veggies.add("женьшень");
        veggies.add("земляника");
        veggies.add("ирис");
        veggies.add("картофель");

        for (String s : veggies) {
            System.out.println(s);
        }

    }
}
