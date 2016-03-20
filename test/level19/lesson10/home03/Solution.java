package com.javarush.test.level19.lesson10.home03;

import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/
import java.io.*;

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            String line = reader.readLine();
            String[] array = line.split(" ");
            int year = Integer.parseInt(array[array.length - 1]);
            int month = Integer.parseInt(array[array.length - 2]);
            int day = Integer.parseInt(array[array.length - 3]);
            String name = array[0];
            if (array.length > 4) {
                for (int i = 1; i < array.length - 3; i++) {
                    name += " " + array[i];
                }
            }
            Calendar calendar = new GregorianCalendar(year, month - 1, day);
            Date date = calendar.getTime();
            Person person = new Person(name, date);
            PEOPLE.add(person);
        }
        reader.close();
    }
}
