package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gesse_000 on 01.03.2016.
 */
public class Solution {

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for (String s : strings) {
            result.add(shortener.getId(s));
        }
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long l : keys) {
            String s = shortener.getString(l);
            if (s != null)
                result.add(s);
        }
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            stringSet.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Date start = new Date();
        Set<Long> resultIds = getIds(shortener, stringSet);
        Date stop = new Date();
        Helper.printMessage(Long.toString(stop.getTime() - start.getTime()));

        start = new Date();
        Set<String> resultStrings = getStrings(shortener, resultIds);
        stop = new Date();
        Helper.printMessage(Long.toString(stop.getTime() - start.getTime()));

        if (resultStrings.equals(stringSet)) Helper.printMessage("Тест пройден.");
        else {
            Helper.printMessage("Тест не пройден.");
        }
    }

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
        testStrategy(new FileStorageStrategy(), 10);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        testStrategy(new HashBiMapStorageStrategy(), 10000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
    }
}
