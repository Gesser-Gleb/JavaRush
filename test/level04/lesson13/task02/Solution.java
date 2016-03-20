package com.javarush.test.level04.lesson13.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String m = r.readLine(), n = r.readLine();
        int im = Integer.parseInt(m), in = Integer.parseInt(n);
        for (int i = 0; i < im; i++)
        {
            for (int j = 0; j < in; j++)
            {
                System.out.print(8);
            }
            System.out.println();
        }
    }

}
