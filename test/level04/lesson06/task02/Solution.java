package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n1 = reader.readLine();
        String n2 = reader.readLine();
        String n3 = reader.readLine();
        String n4 = reader.readLine();
        int in1 = Integer.parseInt(n1);
        int in2 = Integer.parseInt(n2);
        int in3 = Integer.parseInt(n3);
        int in4 = Integer.parseInt(n4);
        int a;
            if (in1 > in2)
                a = in1;
            else
                a = in2;
        {
            if (a > in3 && a >in4)
                System.out.print(a);
            else
            {
                if (in3 > in4)
                    System.out.print(in3);
                else
                    System.out.print(in4);
            }
        }
            //Напишите тут ваш код

    }
}
