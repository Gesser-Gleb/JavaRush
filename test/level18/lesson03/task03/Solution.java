package com.javarush.test.level18.lesson03.task03;

import java.io.FileInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            arrayList.add(data);
        }
        int count = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(i) == arrayList.get(j)) {
                    ++count;
                }
            }
            map.put(arrayList.get(i), count);
            
            count = 0;
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> intMap : map.entrySet()) {

            if (intMap.getValue() > max) {
                max = intMap.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue() == max) {
                System.out.print(integerIntegerEntry.getKey() + " ");
            }
        }

        fileInputStream.close();
    }
}
