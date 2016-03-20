package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static int min(int i, int x) {
        if (i < x) return i;
        else return x;
    }
    public static long min(long i, long x) {
        if (i < x) return i;
        else return x;
    }
    public static double min(double i, double x) {
        if (i < x) return i;
        else return x;
    }

}
