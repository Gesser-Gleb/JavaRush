package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by gesse_000 on 24.10.2015.
 */
public class DirectorTablet {
    public void printAdvertisementProfit(){
        Comparator<Date> reverse = Collections.reverseOrder();
        TreeMap<Date, Float> treeMap = new TreeMap<>(reverse);
        treeMap.putAll(StatisticManager.getInstance().getSumAndDate());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        double total = 0;
        for (Map.Entry<Date, Float> entry :treeMap.entrySet()) {
            System.out.println(dateFormat.format(entry.getKey()) + " - " + String.format(Locale.ENGLISH,"%.2f",entry.getValue()));
            total += entry.getValue();
        }
        System.out.println("Total - " + String.format(Locale.ENGLISH,"%.2f", total));
        System.out.println();
    }
    public void printCookWorkloading() {
        Comparator<Date> reverse = Collections.reverseOrder();
        TreeMap<Date, Map<String, Integer>> treeMap = new TreeMap<>(reverse);
        treeMap.putAll(StatisticManager.getInstance().cookWorkingTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        int sum = 0;
        for (Map.Entry<Date, Map<String, Integer>> entry :treeMap.entrySet()) {
            System.out.println(dateFormat.format(entry.getKey()));
            for (Map.Entry<String, Integer> e :entry.getValue().entrySet()) {
                System.out.println(e.getKey() + " - " + e.getValue());
                sum += e.getValue();
            }
        }
        System.out.println("Total - " + sum + "min");
    }
    public void printActiveVideoSet() {

    }
    public void printArchivedVideoSet() {

    }

}
