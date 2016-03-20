package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        FileReader fileReader = new FileReader(r.readLine());

        String word = "";
        int k = 0;

        while (fileReader.ready())
        {
            int c = fileReader.read();
            Character ch = (char)c;
            if (Character.isLetterOrDigit(ch))
            {
                word += ch;
            }
            else
            {
                if (word.equals("world")) k++;
                word = "";
            }
        }

        System.out.println(k);

        r.close();
        fileReader.close();
    }
}
