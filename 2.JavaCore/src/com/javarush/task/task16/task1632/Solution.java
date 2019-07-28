package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new EternalThread());
        threads.add(new SoutExceptionThread());
        threads.add(new HoorayThread());
        threads.add(new MessageThread());
        threads.add(new NumReaderThread());
    }

    public static void main(String[] args) {

    }

    public static class EternalThread extends Thread {
        public void run() {
            while (true) {

            }
        }
    }

    public static class SoutExceptionThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class HoorayThread extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class MessageThread extends Thread implements Message {
        private boolean repeat = true;

        @Override
        public void showWarning() {
            repeat = false;
        }

        @Override
        public void run() {
            while (repeat);
        }
    }
    public static class NumReaderThread extends Thread {
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = "";
            int sum = 0;
            while (!isInterrupted()) {
                try {
                    input = reader.readLine();
                    if (input.equals("N")) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sum += Integer.parseInt(input);


            }
            System.out.println(sum);
        }
    }


}