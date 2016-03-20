package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;


import java.io.IOException;
import java.util.List;

/**
 * Created by gesse_000 on 29.09.2015.
 */
public class Order {

    public List<Dish> dishes;
    public Tablet tablet;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public int getTotalCookingTime() {
        int cookingTime = 0;
        for (Dish dish : dishes) {
            cookingTime += dish.getDuration();
        }
        return cookingTime;
    }

    public boolean isEmpty() {
        return dishes.size() != 0;
    }

    @Override
    public String toString() {
        if (dishes.size() == 0) return "";
        else
        return "Your order: " + dishes.toString() + " of " + tablet.toString();
    }
}
