package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        FileInputStream in = new FileInputStream(scanner.nextLine());
        FileOutputStream out = new FileOutputStream(scanner.nextLine());
        scanner.close();
        int i = 1;
        while (in.available() > 0){
            if (i % 2 == 0)
                out.write(in.read());
            else
                in.read();
            i++;
        }

        in.close();
        out.close();

    }
}
