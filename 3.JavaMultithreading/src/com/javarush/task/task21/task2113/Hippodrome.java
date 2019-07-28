package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Stallion", 3, 0));
        horses.add(new Horse("Daisy", 3, 0));
        horses.add(new Horse("Spirit", 3, 0));

        game = new Hippodrome(horses);

        game.run();
        game.printWinner();

    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    static Hippodrome game;

    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        double maxDistance = 0;
        for (Horse horse : horses) {
            if (horse.getDistance() > maxDistance) winner = horse;
        }
        return winner;
    }
    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}
