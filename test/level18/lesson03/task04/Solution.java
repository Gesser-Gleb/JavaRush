package com.javarush.test.level18.lesson03.task04;

import java.io.FileInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {

    static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0) {
            arrayList.add(fileInputStream.read());
        }
        int count = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(i) == arrayList.get(j)) {
                    count++;
                }
            }
            map.put(arrayList.get(i), count);
            count = 0;
        }
        for (Map.Entry<Integer, Integer> imap : map.entrySet()) {
            if (imap.getValue() == 1) {
                System.out.print(imap.getKey() + " ");
            }
        }

    }
}
