package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;



/**
 * Created by gesse_000 on 29.09.2015.
 */
public class Restaurant {
    public static void main(String[] args) {

        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Amigo");
        Waitor waitor = new Waitor();
        tablet.addObserver(cook);
        cook.addObserver(waitor);
        tablet.createOrder();

        Tablet t = new Tablet(1);
        Cook c = new Cook("Harmo");
        Waitor w = new Waitor();
        t.addObserver(c);
        c.addObserver(w);
        t.createOrder();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
