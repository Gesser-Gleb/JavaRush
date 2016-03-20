package com.javarush.test.level18.lesson03.task05;

import java.io.FileInputStream;
import java.io.*;
import java.util.SortedSet;
import java.util.TreeSet;
/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {

    static SortedSet<Integer> sortedSet = new TreeSet<Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0) {
            sortedSet.add(fileInputStream.read());
        }
        for (Integer integer : sortedSet) {
            System.out.print(integer + " ");
        }
        fileInputStream.close();
    }
}
