package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            if (ivanov.equals(somePerson)) System.out.println("ivanov == somePerson");

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            if (name != null) {
                writer.write(name);
                writer.newLine();
                if (assets != null) {
                    writer.write("assets");
                    writer.newLine();
                    for (Asset a : assets) {
                        writer.write(a.getName());
                        writer.newLine();
                        writer.write(String.valueOf(a.getPrice()));
                        writer.newLine();
                    }
                } else {
                    writer.write("no assets");
                    writer.newLine();
                }
             writer.flush();
            } else System.out.println("name == null");
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            this.name = reader.readLine();
            String areAssets = reader.readLine();
            if (!areAssets.equals("no assets")) {
                while (reader.ready()) {
                    String assetName = reader.readLine();
                    double assetPrice = Double.parseDouble(reader.readLine());
                    this.assets.add(new Asset(assetName, assetPrice));
                }
            } else this.assets = null;
        }
    }
}
