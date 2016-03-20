package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("q");
        arrayList.add("w");
        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("a");
        arrayList1.add("s");
        ArrayList<String>[] arrayArray = new ArrayList[2];
        arrayArray[0] = arrayList;
        arrayArray[1] = arrayList1;
        //напишите тут ваш код

        return arrayArray;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}