package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/
import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

            String fileName = args[0];
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            Map<String, Double> map = new TreeMap<String, Double>();

            while (fileReader.ready()) {
                String s = fileReader.readLine();
                String[] array = s.split(" ");
                String key = array[0];
                double value = Double.parseDouble(array[1]);


                for (Iterator<Map.Entry<String, Double>> stEntry = map.entrySet().iterator(); stEntry.hasNext(); ) {
                    Map.Entry<String, Double> entry = stEntry.next();
                    if (key.equals(entry.getKey())) {
                        value += entry.getValue();
                        stEntry.remove();
                    }
                }
                map.put(key, value);

            }
            for (Map.Entry<String, Double> stringDoubleEntry : map.entrySet()) {
                System.out.println(stringDoubleEntry.getKey() + " " + stringDoubleEntry.getValue());
            }
            fileReader.close();
    }
}
