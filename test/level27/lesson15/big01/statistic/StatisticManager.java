package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;


import java.util.*;


/**
 * Created by gesse_000 on 24.10.2015.
 */
public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    StatisticStorage storage = new StatisticStorage();
    Set<Cook> set = new HashSet<>();

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        //TODO
        storage.put(data);
    }

    public Map<Date, Float> getSumAndDate() {
        return storage.getSumByDayAdv();
    }

    public Map<Date, Map<String, Integer>> cookWorkingTime(){
        return storage.cookWorking();
    }


    private class StatisticStorage {
        Map<EventType, List<EventDataRow>> map;

        public StatisticStorage() {
            this.map = new HashMap<>();
            for (int i = 0; i < EventType.values().length; i++) {
                map.put(EventType.values()[i], new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            map.get(data.getType()).add(data);
       }

        private Map<Date, Float> getSumByDayAdv() {
            Map<Date, Float> result = new TreeMap<>();
            List<EventDataRow> list;
            for (Map.Entry<EventType, List<EventDataRow>> entry :map.entrySet()) {
                if (entry.getKey().equals(EventType.SELECTED_VIDEOS)) {
                    list = entry.getValue();
                    for (EventDataRow e :list) {
                        if (((VideoSelectedEventDataRow) e).getAmount() > 0) {
                            float amount = (float)((VideoSelectedEventDataRow) e).getAmount();
                            result.put(e.getDate(), amount/100);
                        }
                    }
                }
            }
            return result;
        }

        private Map<Date, Map<String, Integer>> cookWorking() {
            Map<Date, Map<String, Integer>> result = new TreeMap<>();
            Map<String, Integer> inner = new HashMap<>();
            List<EventDataRow> list;
            for (Map.Entry<EventType, List<EventDataRow>> entry :map.entrySet()) {
                if (entry.getKey().equals(EventType.COOKED_ORDER)) {
                    list = entry.getValue();
                    for (EventDataRow e :list) {
                        String name = ((CookedOrderEventDataRow) e).getCookName();
                        int amount = e.getTime()/60;
                        inner.put(name, amount);
                        result.put(e.getDate(), inner);
                    }
                }
            }
            return result;
        }
    }

    public void register(Cook cook) {

        set.add(cook);
    }
}
