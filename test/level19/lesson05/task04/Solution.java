package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine(),
                secondFileName = reader.readLine();
        FileReader fileReader = new FileReader(firstFileName);
        FileWriter fileWriter = new FileWriter(secondFileName);
        String  s = "";
        while (fileReader.ready()) {
            s = (char)fileReader.read() + "";
            if (s.equals(".")) {
                s = "!";
            }
            fileWriter.write(s);
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
