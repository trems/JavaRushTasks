package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // List of addresses
        List<String> citiesAndFamilies = new ArrayList<>();
        while (true) {
            String city = reader.readLine();
            citiesAndFamilies.add(city);
            if (city.isEmpty()) {
                break;
            }
            String family = reader.readLine();
            citiesAndFamilies.add(family);


        }

        // Read the city name
        String cityName = reader.readLine();

        for (int i = 0; i < citiesAndFamilies.size(); i++) {
            if (cityName.equals(citiesAndFamilies.get(i))) {
                System.out.println(citiesAndFamilies.get(i+1));
            }
        }
    }
}
