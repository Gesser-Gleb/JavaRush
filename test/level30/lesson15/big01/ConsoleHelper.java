package com.javarush.test.level30.lesson15.big01;

/**
 * Created by gesse_000 on 09.01.2016.
 */
import java.io.*;
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {

        try {
           return reader.readLine();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
        }
        return readString();
    }

    public static int readInt() {

        try {
            return Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
        }
        return readInt();
    }
}
