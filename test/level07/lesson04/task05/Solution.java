package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        int[] ar1 = new int[10];
        int[] ar2  = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(r.readLine());
        }
        for (int i = 0; i < ar1.length; i++) {
            ar1[i] = array[i];
        }
        for (int i = 0; i < ar2.length; i++) {
            ar2[i] = array[i + 10];
        }
        for (int i = 0; i < ar2.length; i++) {
            System.out.println(ar2[i]);
        }
    }
}
