package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by gesse_000 on 11.09.2015.
 */
public class Producer implements Runnable {

    ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        int count = 1;
        try {
            while (true) {
                System.out.println("Some text for " + count);
                count++;
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
