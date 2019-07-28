package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        protected A clone() throws CloneNotSupportedException {
            return (A)super.clone();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            A a = (A) o;

            if (i != a.i) return false;
            return j == a.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }


        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        protected C clone() throws CloneNotSupportedException {
            C c = new C(this.getI(), this.getJ(), this.getName());
            return c;
        }
    }

    public static void main(String[] args) {
//        B b1 = new B(5, 6, "b1");
//        C c1 = new C(6, 8, "c!");
//        A a1 = new A(1, 2);
//        try {
//            A a2 = a1.clone();
//            System.out.println(a1);
//            System.out.println(a2);
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        try {
//            B b2 = b1.clone();
//            System.out.println(b1);
//            System.out.println(b2);
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        try {
//            C c2 = c1.clone();
//            System.out.println(c1);
//            System.out.println(c2);
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }

    }
}
