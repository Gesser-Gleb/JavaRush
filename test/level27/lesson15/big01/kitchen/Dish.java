package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by gesse_000 on 29.09.2015.
 */
public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    public static String allDishesToString(){
        Dish[] dish = Dish.values();
        if (Dish.values() == null) return "";
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(dish[0]);
            for (int i = 1; i < dish.length; i++) {
                sb.append(", " + dish[i]);
            }
            return sb.toString();
        }
    }

    private int duration;

    public int getDuration() {
        return duration;
    }

    Dish(int duration) {
        this.duration = duration;
    }
}
