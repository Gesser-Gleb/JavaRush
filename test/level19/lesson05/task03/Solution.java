package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine(),
                secondFileName = reader.readLine();
        FileReader fileReader = new FileReader(firstFileName);
        FileWriter fileWriter = new FileWriter(secondFileName);
        String s = "";
        while (fileReader.ready()) {
            s += (char)fileReader.read();
        }
        String[] array = s.split(" ");
        for (String s1 : array) {
            try {
                int data = Integer.parseInt(s1);
                String space = data + " ";
                fileWriter.write(space);
            } catch (Exception e){

            }
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
