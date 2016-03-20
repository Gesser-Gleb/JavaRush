package com.javarush.test.level13.lesson02.task05;

/* 4 ошибки
Исправь 4 ошибки в программе, чтобы она компилировалась.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {

        System.out.println(new Hobbie().HOBBIE.toString());
        System.out.println(new Hobbie().toString());

    }

        interface Desire
        {
            public String toString();
        }

        interface Dream
        {
            public Hobbie HOBBIE = new Hobbie();
        }

        static class Hobbie implements Dream, Desire
        {
            public static int INDEX = 1;

            @Override
            public String toString()
            {
                INDEX++;
                return "" + INDEX;
            }
        }

}
