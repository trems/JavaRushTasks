package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String personLine = "";
            if (fileScanner.hasNext()) {
                personLine = fileScanner.nextLine();
            }
            String[] personArgs = personLine.split(" ");
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date bd = new Date();
            try {
                bd = df.parse(personArgs[3]+"/"+personArgs[4]+"/"+personArgs[5]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return new Person(personArgs[1], personArgs[2], personArgs[0], bd);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
