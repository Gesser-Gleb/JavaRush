package com.javarush.test.level15.lesson12.home04;

/**
 * Created by gesse_000 on 08.07.2015.
 */
public class Moon implements Planet {
    private static Moon instance;
    private Moon() {}

    public static Moon getInstance() {
        if (instance == null) {
            instance = new Moon();
        }
        return instance;
    }
}
