package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;
import java.util.*;

/**
 * Created by gesse_000 on 11.09.2015.
 */
public class CurrencyManipulator {
    private String currencyCode;
    Map<Integer, Integer> denominations = new HashMap<>();

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;

    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }
    
    public int getTotalAmount() {
        int sum = 0;

        for (Map.Entry<Integer, Integer> entry: denominations.entrySet()) {
            sum += entry.getKey() * entry.getValue();
        }
        return sum;
    }

    public boolean hasMoney() {
        return denominations.size() != 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {


        Comparator<Integer> reverse = Collections.reverseOrder();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(reverse);
        treeMap.putAll(denominations);


        Map<Integer, Integer> resultMap = new TreeMap<>(reverse);
        int eAmount = expectedAmount;

            for (Iterator<Map.Entry<Integer, Integer>> it = treeMap.entrySet().iterator(); it.hasNext();) {
                Map.Entry<Integer, Integer> entry = it.next();

                int key = entry.getKey();
                int value = entry.getValue();
                while (true) {
                    if (eAmount < key || value <= 0) {
                        treeMap.put(key, value);
                        break;
                    }
                    eAmount -= key;
                    value--;

                    if (resultMap.containsKey(key))
                        resultMap.put(key, resultMap.get(key) + 1);
                    else
                        resultMap.put(key, 1);
                }
            }

        if (eAmount > 0)
            throw new NotEnoughMoneyException();
        else
        {
            for (Map.Entry<Integer, Integer> pair : resultMap.entrySet())
                ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());

            denominations.clear();
            denominations.putAll(treeMap);
            ConsoleHelper.writeMessage("Transaction was successful!");
        }
        return resultMap;
    }
}
