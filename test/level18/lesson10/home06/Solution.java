package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
       if (args.length > 0) {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            Map<Character, Integer> map = new TreeMap<Character, Integer>();
            List<Character> list = new ArrayList<Character>();
            while (fileInputStream.available() > 0) {
                list.add((char)fileInputStream.read());
            }
        int value = 0;
        for (Character character : list) {
            if (map.containsKey(character)) {
               value = map.get(character) + 1;
            } else {
                value = 1;
            }
            map.put(character, value);
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            System.out.println(characterIntegerEntry.getKey() + " " + characterIntegerEntry.getValue());
        }
           fileInputStream.close();
       }
    }
}
