package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream fileInput = new FileInputStream(fileName1);
        FileOutputStream fileOutFirst = new FileOutputStream(fileName2);
        FileOutputStream fileOutSecond = new FileOutputStream(fileName3);
/*
        byte[] buffer = new byte[fileInput.available()];
        int count = fileInput.read(buffer, 0, fileInput.available());

        if (fileInput.available() % 2 == 0){

                fileOutFirst.write(buffer, 0, count/2);
                fileOutSecond.write(buffer, count/2, count);
        } else {

                fileOutFirst.write(buffer, 0, count/2 + 1);
                fileOutSecond.write(buffer, count/2 + 1, count);
            }
*/
        int fileSize = fileInput.available();
        byte[] buffer = new byte[fileSize];
        int count = fileInput.read(buffer, 0, fileSize);
        int half2 = count / 2;
        int half1 = fileSize - half2;
        fileOutFirst.write(buffer,0, half1);
        fileOutSecond.write(buffer,half1, half2);

        reader.close();
        fileInput.close();
        fileOutFirst.close();
        fileOutSecond.close();
    }
}
