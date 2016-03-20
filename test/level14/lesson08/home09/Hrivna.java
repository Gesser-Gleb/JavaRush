package com.javarush.test.level14.lesson08.home09;

/**
 * Created by gesse_000 on 02.07.2015.
 */
public class Hrivna extends Money {
    @Override
    public String getCurrencyName() {
        return "HRN";
    }
    @Override
    public double getAmount() {
        return super.getAmount();
    }

    public Hrivna(double amount) {
        super(amount);
    }
}
