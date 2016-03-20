 package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/
 import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine(),
                fileName2 = reader.readLine(),
                fileName3 = reader.readLine();
        reader.close();
        FileInputStream fileInputSecond = new FileInputStream(fileName2);
        FileOutputStream fileOutputFirst = new FileOutputStream(fileName1);
        FileInputStream fileInputThird = new FileInputStream(fileName3);
        while (fileInputSecond.available() > 0) {
            int data = fileInputSecond.read();
            fileOutputFirst.write(data);
        }
        while (fileInputThird.available() > 0) {
            fileOutputFirst.write(fileInputThird.read());
        }
        fileInputSecond.close();
        fileInputThird.close();
        fileOutputFirst.close();
    }
}
