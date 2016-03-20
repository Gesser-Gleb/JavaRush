package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine(),
                fileName2 = reader.readLine();
        FileInputStream fileInput = new FileInputStream(fileName);
        FileOutputStream fileOutput = new FileOutputStream(fileName2);
        int size = fileInput.available();
        byte[] buffer = new byte[size];
        fileInput.read(buffer);
        for (int i = buffer.length - 1; i >= 0 ; i--) {

            fileOutput.write(buffer[i]);
        }
        reader.close();
        fileInput.close();
        fileOutput.close();

    }
}
