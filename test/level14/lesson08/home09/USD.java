package com.javarush.test.level14.lesson08.home09;

/**
 * Created by gesse_000 on 02.07.2015.
 */
public class USD extends Money {
    @Override
    public String getCurrencyName() {
        return "USD";
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }
    public USD(double amount) {
        super(amount);
    }
}
