package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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
        int in1 = Integer.parseInt(n1);
        int in2 = Integer.parseInt(n2);
        int in3 = Integer.parseInt(n3);
            if (in1 > in2 && in2 > in3 && in1>in3 )
                System.out.print(in1 + " " + in2 + " " + in3);
                 else if (in1 > in2 && in3 > in2 && in1 > in3)
                     System.out.println(in1 + " " + in3 + " " + in2);
                     else if (in2 > in1 && in1 > in3 && in2> in3)
                        System.out.print(in2 + " " + in1 + " " + in3);
                        else if (in2 > in1 && in3 > in1 && in2 > in3)
                            System.out.print(in2 + " " + in3 + " " + in1);
                            else if (in3 > in1 && in1 > in2 && in3 > in2)
                                System.out.print(in3 + " " + in1 + " " + in2);
                                else
                                    System.out.print(in3 + " " + in2 + " " + in1);
            }
        //Напишите тут ваш код

    }
