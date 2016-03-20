package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int  maximum;
        int  minimum;

        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            a.add(Integer.parseInt(reader.readLine()));
        }
        maximum = a.get(0);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > maximum) {
                maximum = a.get(i);
            }
        }
        minimum = a.get(0);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) < minimum) {
                minimum = a.get(i);
            }
        }
        System.out.println(maximum);
        System.out.println(minimum);
    }
}
