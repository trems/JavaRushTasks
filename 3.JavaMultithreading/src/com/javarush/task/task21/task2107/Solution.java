package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);
            System.out.println(solution.users == clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }
    public Solution clone() throws CloneNotSupportedException {
        Solution s = (Solution) super.clone();
        s.users = new LinkedHashMap<>(users);
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solution solution = (Solution) o;

        return users != null ? users.equals(solution.users) : solution.users == null;

    }

    @Override
    public int hashCode() {
        return users != null ? users.hashCode() : 0;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
        public User clone() {
            User user = new User(this.age, this.name);
            return user;
        }
    }
}
