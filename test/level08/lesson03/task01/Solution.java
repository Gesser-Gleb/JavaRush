package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import java.util.HashSet;
import java.util.Set;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Set<String> food = new HashSet<String>();
        food.add("арбуз");
        food.add("банан");
        food.add("вишня");
        food.add("груша");
        food.add("дыня");
        food.add("ежевика");
        food.add("жень-шень");
        food.add("земляника");
        food.add("ирис");
        food.add("картофель");
        for (String s : food)
        {
            System.out.println(s);
        }

    }
}
