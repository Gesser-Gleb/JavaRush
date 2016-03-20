package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] integers = new int[5];
        for (int i = 0; i < 5; i++) {
            int c = Integer.parseInt(reader.readLine());
            integers[i] = c;
        }
        sort(integers);
        for (int x : integers) {
            System.out.println(x);
        }
    }
    public static void sort(int[] integers)
    {
        int b;
        for (int i = 0; i < integers.length; i++)
        {
            for (int j = 0; j < integers.length; j++)
            {
                if (integers[i] < integers[j])
                {
                    b = integers[i];
                    integers[i] = integers[j];
                    integers[j] = b;
                }
            }
        }
    }
}
