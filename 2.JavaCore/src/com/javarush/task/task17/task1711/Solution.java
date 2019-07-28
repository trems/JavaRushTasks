package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i+=3) {
                        String name = args[i];
                        String sex = args[i+1];
                        String bd = args[i+2];
                        if (sex.equals("м")) {
                            allPeople.add(Person.createMale(name, birthDateParse(bd)));
                        }
                        else if (sex.equals("ж")) {
                            allPeople.add(Person.createFemale(name, birthDateParse(bd)));
                        }
                        System.out.println((allPeople.size()-1));
                    }
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i+=4) {
                        String id = args[i];
                        String name = args[i+1];
                        String sex = args[i+2];
                        String bd = args[i+3];
                        Person updatingPerson = allPeople.get(Integer.parseInt(id));
                        updatingPerson.setName(name);
                        if (sex.equals("м")) updatingPerson.setSex(Sex.MALE);
                        else if (sex.equals("ж")) updatingPerson.setSex(Sex.FEMALE);
                        updatingPerson.setBirthDate(birthDateParse(bd));
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        String id = args[i];
                        Person deletePerson = allPeople.get(Integer.parseInt(id));
                        deletePerson.setName(null);
                        deletePerson.setSex(null);
                        deletePerson.setBirthDate(null);
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        String id = args[i];
                        Person targetPerson = allPeople.get(Integer.parseInt(id));
                        System.out.println(targetPerson);
                    }
                }
                break;
        }
       // System.out.println(allPeople.size());

    }

    public static Date birthDateParse(String bdString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date bd = dateFormat.parse(bdString);
        return bd;
    }
}
