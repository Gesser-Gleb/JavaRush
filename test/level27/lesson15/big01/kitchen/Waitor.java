package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by gesse_000 on 03.10.2015.
 */
public class Waitor implements Observer {
    @Override
    public void update(Observable observable, Object arg) {
        ConsoleHelper.writeMessage(arg + " was cooked by " + observable);
    }
}
