package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File yourFile = File.createTempFile("your_file_name", null);
            String yourFile = "/home/mike/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2002/1";
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
//            for (int i = 1; i < 10; i++) {
//                User user = new User();
//                user.setFirstName("First"+i);
//                user.setLastName("Last"+i);
//                user.setBirthDate(new Date());
//                user.setCountry(User.Country.RUSSIA);
//                user.setMale((int)(2 * Math.random()) == 1);
//                javaRush.users.add(user);
//            }

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.equals(loadedObject)) System.out.println("they are equal!");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            if (users.isEmpty()) {
                writer.write("users:null");
                writer.newLine();
            } else {
                writer.write("users:");
                writer.newLine();
                for (User u : users) {
                    writer.write(u.getFirstName());
                    writer.newLine();
                    writer.write(u.getLastName());
                    writer.newLine();
                    writer.write(u.getBirthDate().toString());
                    writer.newLine();
                    writer.write(String.valueOf(u.isMale()));
                    writer.newLine();
                    writer.write(u.getCountry().toString());
                    writer.newLine();
                }
                writer.flush();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String areUsers = "";
            if (reader.ready()) {
                areUsers = reader.readLine();
            }
            if (areUsers.equals("users:")) {
                while (reader.ready()) {
                    User user = new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    user.setBirthDate(new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH).parse(reader.readLine()));
                    user.setMale(Boolean.parseBoolean(reader.readLine()));
                    user.setCountry(User.Country.valueOf(reader.readLine()));
                    users.add(user);

                }
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
