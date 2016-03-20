package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<String> dates = new ArrayList<String>();
        dates.add(0,"January");
        dates.add(1,"February");
        dates.add(2,"March");
        dates.add(3,"April");
        dates.add(4,"May");
        dates.add(5,"June");
        dates.add(6,"July");
        dates.add(7,"August");
        dates.add(8,"September");
        dates.add(9,"October");
        dates.add(10,"November");
        dates.add(11,"December");

        for (int i = 0; i < dates.size(); i++) {
            if (s.equals(dates.get(i))) {
                System.out.println(s + " is " + (i+1) + " month");
            }
        }

    }

}
