package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/
import java.io.*;

public class Solution {

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInput = new FileInputStream(fileName);
        while (fileInput.available() > 0) {
            if (fileInput.read() == 44) count++;
        }
        System.out.println(count);
        reader.close();
        fileInput.close();
    }
}
