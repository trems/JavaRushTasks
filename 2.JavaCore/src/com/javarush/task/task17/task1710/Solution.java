package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args.length > 0) {
            if (args[0].equals("-c")) createPerson(args);
            if (args[0].equals("-u")) updatePerson(args);
            if (args[0].equals("-d")) deletePerson(args[1]);
            if (args[0].equals("-i")) printPerson(args[1]);
        }

    }

    //парсер даты для create и update
    public static Date birthDateParse(String bdString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date bd = dateFormat.parse(bdString);
        return bd;
    }

    public static void createPerson(String[] args) throws ParseException {
        String name = args[1];
        String sex = args[2];
        String bd = args[3];
        if (sex.equals("м")) {
            allPeople.add(Person.createMale(name, birthDateParse(bd)));
        }
        else if (sex.equals("ж")) {
            allPeople.add(Person.createFemale(name, birthDateParse(bd)));
        }
        System.out.println((allPeople.size()-1));
    }
    public static void updatePerson(String[] args) throws ParseException {
        String id = args[1];
        String name = args[2];
        String sex = args[3];
        String bd = args[4];
        Person updatingPerson = allPeople.get(Integer.parseInt(id));
        updatingPerson.setName(name);
        if (sex.equals("м")) updatingPerson.setSex(Sex.MALE);
        else if (sex.equals("ж")) updatingPerson.setSex(Sex.FEMALE);
        updatingPerson.setBirthDate(birthDateParse(bd));
    }
    public static void deletePerson(String id) {
        Person deletePerson = allPeople.get(Integer.parseInt(id));
        deletePerson.setName(null);
        deletePerson.setSex(null);
        deletePerson.setBirthDate(null);
    }
    public static void printPerson(String id) {
        Person targetPerson = allPeople.get(Integer.parseInt(id));
        System.out.println(targetPerson);
    }
}
