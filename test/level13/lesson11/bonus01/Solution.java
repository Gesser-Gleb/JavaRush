package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/
import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()) {
            int i = Integer.parseInt(bufferedReader.readLine());
            if (i % 2 == 0) list.add(i);
        }
        int count;
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size() ; i++) {
            array[i] = list.get(i);
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    count = array[i];
                    array[i] = array[j];
                    array[j] = count;
                }
            }
        }
        for (Integer integer : array) {
            System.out.println(integer);
        }

    }
}
