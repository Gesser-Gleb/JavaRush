package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;


/**
 * Created by gesse_000 on 24.08.2015.
 */
public class Hippodrome {
    public static Hippodrome game;
    private ArrayList<Horse> horses = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        game = new Hippodrome();

        game.getHorses().add(new Horse("Loshadka", 3.0, 0.0));
        game.getHorses().add(new Horse("Sorvi-Golova", 3.0, 0.0));
        game.getHorses().add(new Horse("Silach", 3.0, 0.0));
        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }
    public void run() throws InterruptedException {
        for (int i = 1; i <= 100 ; i++) {
            move();
            print();
            Thread.sleep(500);
        }
    }
    public void print() {
        for (Horse horse : horses) {
            horse.print();
            System.out.println();
            System.out.println();
        }

    }
    public void move() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
        }
    }
    public Horse getWinner() {

        Horse winner = getHorses().get(0);
        for (Horse horse : horses) {
            if (horse.getDistance() > winner.getDistance()) {
                winner = horse;
            }
        }
        return winner;
    }
    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
