package com.javarush.test.level07.lesson09.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> s = new ArrayList<String>();
        s.add("мама");
        s.add("мыла");
        s.add("раму");
        for (int i = 1; i < s.size() + 1; i = i + 2) {
            s.add(i, "именно");
        }
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }
    }
}
