package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        List<String> city = new ArrayList<String>();
        List<String> family = new ArrayList<String>();
        for (int i = 0;; i++)
        {
            String words = reader.readLine();
            if (words.isEmpty()) break;
            if (i % 2 == 0) {
                city.add(words);
            }
            else family.add(words);
        }


        String findCity = reader.readLine();

        for (int i = 0; i < city.size(); i++) {
            if (findCity.equals(city.get(i))) {
                System.out.println(family.get(i));
            }
        }



    }
}
