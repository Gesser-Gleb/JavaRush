package com.javarush.test.level33.lesson15.big01;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by gesse_000 on 01.03.2016.
 */
public class Helper {
    public static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(50, random).toString();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
