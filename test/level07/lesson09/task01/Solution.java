package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка  с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> integer = new ArrayList<Integer>();
        ArrayList<Integer> integer3 = new ArrayList<Integer>();
        ArrayList<Integer> integer2 = new ArrayList<Integer>();
        ArrayList<Integer> integerrr = new ArrayList<Integer>();

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            integer.add(Integer.parseInt(r.readLine()));
        }
        for (int i = 0; i < integer.size(); i++) {
            if (integer.get(i) % 3 == 0) {
                integer3.add(integer.get(i));
            }
            if (integer.get(i) % 2 == 0) {
               integer2.add(integer.get(i));
            }
            if (integer.get(i) % 3 != 0 && integer.get(i) % 2 != 0)
                integerrr.add(integer.get(i));
        }
        printList(integer3);
        printList(integer2);
        printList(integerrr);
    }

    public static void printList(List<Integer> list) {
        for (Integer i : list)
            System.out.println(i);
    }
}
