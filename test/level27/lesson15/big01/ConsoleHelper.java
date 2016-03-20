package com.javarush.test.level27.lesson15.big01;

/**
 * Created by gesse_000 on 29.09.2015.
 */
import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> list = new ArrayList<>();
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        writeMessage("Please, choose the dish or enter 'exit'.");
        while (true) {

            String result = readString();
            if (result.equalsIgnoreCase("exit")) break;
            try {
                Dish dish = Dish.valueOf(result);
                list.add(dish);
            }catch (IllegalArgumentException e){
                ConsoleHelper.writeMessage(result + " is not detected");
            }
        }
        return list;
    }
}
