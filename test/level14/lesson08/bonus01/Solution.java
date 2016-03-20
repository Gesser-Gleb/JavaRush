package com.javarush.test.level14.lesson08.bonus01;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try {
            String s = null;
            int a = Integer.parseInt(s);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] ints = new int[5];
            ints[7] = 6;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            class Hand {
            }
            class Leg {
            }
            Object o = new Leg();
            Object p = new Hand();
            Leg a = (Leg)p;
            } catch (Exception e) {
            exceptions.add(e);
        }
        //Add your code here
        try {
            Object [] i = new String[5];
            i[0] = new Character('a');
        }
        catch(Exception e){
            exceptions.add(e);
        }
        try {
            int[] ii = new int[-5];
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            File.createTempFile("y","");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            String classto = "f_g";
            Class c = Class.forName(classto);


        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
           Object o = null;
            o.equals("kkk");

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
          throw new IllegalAccessException();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
