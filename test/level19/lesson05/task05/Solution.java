package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine(),
                secondFileName = reader.readLine();
        FileReader fileReader = new FileReader(firstFileName);
        FileWriter fileWriter = new FileWriter(secondFileName);
        while (fileReader.ready()) {
            int data = fileReader.read();
            if (!((data > 32 && data < 48) || (data > 57 && data < 64)
                    || (data > 90 && data < 97) || (data > 122 && data < 126))) {
                fileWriter.write(data);
            }
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
