package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gesse_000 on 06.03.2016.
 */
public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date start = new Date();
        for (String s :strings) {
            ids.add(shortener.getId(s));
        }
        Date end = new Date();

        return end.getTime() - start.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date start = new Date();
        for (Long aLong : ids) {
            strings.add(shortener.getString(aLong));
        }
        Date end = new Date();

        return end.getTime() - start.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        Set<Long> idS1 = new HashSet<>();
        Set<Long> idS2 = new HashSet<>();

        for (int i = 0; i < 10000 ; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        Long time1 = getTimeForGettingIds(shortener1, origStrings, idS1);
        Long time2 = getTimeForGettingIds(shortener2, origStrings, idS2);
        Assert.assertTrue(time1 > time2);

        time1 = getTimeForGettingStrings(shortener1, idS1, new HashSet<String>());
        time2 = getTimeForGettingStrings(shortener2, idS2, new HashSet<String>());
        Assert.assertEquals(time1, time2, 5);
    }

}
