package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз – ягода, банан – трава, вишня – ягода, груша – фрукт, дыня – овощ, ежевика – куст, жень-шень – корень,
земляника – ягода, ирис – цветок, картофель – клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель – клубень
*/

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Map<String, String> food = new HashMap<String, String>();
        food.put("арбуз","ягода");
        food.put("банан","трава");
        food.put("вишня","ягода");
        food.put("груша","фрукт");
        food.put("дыня","овощ");
        food.put("ежевика","куст");
        food.put("жень-шень","корень");
        food.put("земляника","ягода");
        food.put("ирис","цветок");
        food.put("картофель","клубень");
        for (Map.Entry<String, String> stEntry : food.entrySet())
        {
            String key = stEntry.getKey();
            String value = stEntry.getValue();
            System.out.println(key + " - " + value);
        }

    }
}
