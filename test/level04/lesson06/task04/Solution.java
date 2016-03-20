package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны».
Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String n1 = r.readLine(), n2 = r.readLine();
        int i1 = n1.length(), i2 = n2.length();
        if (n1.equals(n2))
            System.out.println("Имена идентичны");
        else if (i1 == i2)
            System.out.println("Длины имен равны");

        //Напишите тут ваш код

    }
}
