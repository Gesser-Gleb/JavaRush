package com.javarush.test.level08.lesson08.task01;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> lString = new HashSet<String>();
        lString.add("Ложка");
        lString.add("Лицо");
        lString.add("Липа");
        lString.add("Ластик");
        lString.add("Лазарь");
        lString.add("Лазурь");
        lString.add("Лист");
        lString.add("Лампа");
        lString.add("Ложе");
        lString.add("Локоть");
        lString.add("Лестница");
        lString.add("Латунь");
        lString.add("Лихо");
        lString.add("Ласточка");
        lString.add("Лапоть");
        lString.add("Лифт");
        lString.add("Лира");
        lString.add("Лось");
        lString.add("Лот");
        lString.add("Лента");

        return lString;
    }

    public  static void printerSet(HashSet<String> lString) {
        for (String s : lString) {
            System.out.println(s);

        }

    }

    public static void main(String[] args) {
        printerSet(createSet());
    }
}
