package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by gesse_000 on 05.07.2015.
 */
public class Singleton {
    static Singleton instance;
    private Singleton() {

    }
    static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

