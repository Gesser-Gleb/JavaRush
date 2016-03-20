package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Date;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static void main(String[] args)
    {
        Long t0 = System.currentTimeMillis();
        int n = 100000000;
        int[] numbers = getNumbers(n);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();

    }
    public static int[] getNumbers(int N) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1;i < N;i++)
        {
            if (isArmStrong(i)) list.add(i);
        }
        int[] result = null;
        result = new int[list.size()];
        for (int i = 0; i<list.size();i++)
            result[i] = list.get(i);
        return result;
    }
    private static boolean isArmStrong(int number) {
        int result = 0;
        int orig = number;
        int exp = Integer.toString(orig).length();
        while(number != 0){
            int remainder = number%10;
            result += power(remainder,exp);
            number = number/10;
        }
        //number is Armstrong return true
        if(orig == result){
            return true;
        }
        return false;
    }
    static int power(double x, long n)
    {
        int result = 1;
        while (n != 0)
        {
            if (n % 2 != 0)
            {
                result *= x;
                n -= 1;
            }
            x *= x;
            n /= 2;
        }
        return result;
    }
}


