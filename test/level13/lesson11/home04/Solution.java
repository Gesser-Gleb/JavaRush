package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/
import java.io.*;
import java.io.IOException;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        OutputStream outputStream = new FileOutputStream(filename);

        while (true) {
            String s = reader.readLine();

            if (s.equals("exit")) {
                outputStream.write(s.getBytes());
                break;
            }
            else
                outputStream.write((s + "\r\n").getBytes());
            
        }
        outputStream.close();
        reader.close();

    }



}
