package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> integers = new HashSet<Integer>();
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int inumber = random.nextInt();
            integers.add(inumber);
        }
        return integers;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            if (iter.next() > 10) iter.remove();
        }
        return set;

    }
    public static void print(HashSet<Integer> integers) {
        for (Integer integ : integers) {
            System.out.println(integ);
        }

    }

    public static void main(String[] args) {
        print(createSet());
        System.out.println();
        print(removeAllNumbersMoreThan10(createSet()));


    }
}
