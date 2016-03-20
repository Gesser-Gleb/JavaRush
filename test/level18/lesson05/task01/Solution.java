package com.javarush.test.level18.lesson05.task01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* Исправить ошибки
Исправить функциональность в соответствии с требованиями
Программа должна:
1. переписать все байты одного файла в другой одним куском.
2. закрывать потоки ввода-вывода
Подсказка: 4 ошибки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\gesse_000\\Desktop\\data.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\gesse_000\\Desktop\\result.txt");

        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
        }

        inputStream.close();
        outputStream.close();
    }
}
