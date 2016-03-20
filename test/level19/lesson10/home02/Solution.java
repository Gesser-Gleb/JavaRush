package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException{
        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        Map<String, Double> map = new HashMap<String, Double>();
        while (reader.ready()) {
            String s = reader.readLine();
            String[] array = s.split(" ");
            String key = array[0];
            double value = Double.parseDouble(array[1]);

            for (Iterator<Map.Entry<String, Double>> entryIterator = map.entrySet().iterator(); entryIterator.hasNext(); ) {
                Map.Entry<String, Double> entry = entryIterator.next();
                if (key.equals(entry.getKey())) {
                    value += entry.getValue();
                    entryIterator.remove();
                }
            }
            map.put(key, value);
        }
        double max = 0;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() > max) max = entry.getValue();
        }
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println(entry.getKey());
            }
        }
        reader.close();
    }
}
