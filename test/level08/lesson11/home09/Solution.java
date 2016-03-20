package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true,
если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        String s = "JANUARY 2 2013";
        isDateOdd(s);
        System.out.println(s + " = " + isDateOdd(s));
    }

    public static boolean isDateOdd(String date)
    {
        Date nullDate = new Date();
        nullDate.setMonth(0);
        nullDate.setDate(1);
        Date userDate = new Date(date);
        long ms = userDate.getTime() - nullDate.getTime();
        long msToDay = ms/(1000*60*60*24);
        if (msToDay % 2 == 0) return true;
        else
            return false;
    }
}
