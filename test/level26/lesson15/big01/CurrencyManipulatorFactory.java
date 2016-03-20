package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;



/**
 * Created by gesse_000 on 11.09.2015.
 */
public final class CurrencyManipulatorFactory {

    public static HashMap<String, CurrencyManipulator> map = new HashMap<>();

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {

        CurrencyManipulator manipulator;

        if (map.containsKey(currencyCode)) {
            return map.get(currencyCode);
        } else {
            manipulator = new CurrencyManipulator(currencyCode);
            map.put(currencyCode,manipulator);
            return manipulator;
        }
    }

    private CurrencyManipulatorFactory() {
    }


}
