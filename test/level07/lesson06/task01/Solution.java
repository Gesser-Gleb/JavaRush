package com.javarush.test.level07.lesson06.task01;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> s = new ArrayList<String>();
        s.add("asd");
        s.add("fgh");
        s.add("jkl");
        s.add("zxc");
        s.add("vbn");
        System.out.println(s.size());
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }
    }
}
