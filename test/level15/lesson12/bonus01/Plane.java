package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by gesse_000 on 09.07.2015.
 */
public class Plane implements Flyable {
    @Override
    public void fly() {

    }
    int count;
    public Plane(int count) {
        this.count = count;
    }
}
