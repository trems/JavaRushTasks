package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        if (args.length > 0) {
            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

            SimpleDateFormat df = new SimpleDateFormat("dd M yyyy");

            String currentLine;
            StringBuilder sb = new StringBuilder();
            while (fileReader.ready()) {
                currentLine = fileReader.readLine();
                String[] parts = currentLine.split("(\\s+)");

                for (int i = 0; i < parts.length-3; i++) {
                    sb.append(parts[i]).append(" ");
                }
                Date bd = df.parse(parts[parts.length-3].trim()+" "+parts[parts.length-2].trim()+" "+parts[parts.length-1].trim());
                String name = sb.toString().trim();
                sb.delete(0, sb.length());
                PEOPLE.add(new Person(name, bd));
            }
            fileReader.close();
//            System.out.println(PEOPLE.get(0));
//            System.out.println(PEOPLE.get(1));
        }

    }
}
