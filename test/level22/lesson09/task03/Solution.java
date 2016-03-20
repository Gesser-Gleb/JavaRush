package com.javarush.test.level22.lesson09.task03;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution
{
    public static void main(String[] args)
    {

        try (Scanner scanner = new Scanner(System.in);
             FileInputStream file = new FileInputStream(scanner.nextLine())
        )
        {
            byte[] text = new byte[file.available()];
            file.read(text);
            String[] words = new String(text).trim().split("\\s+[\\r\\n]*");
            StringBuilder result = getLine(words);
            System.out.println(result.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static StringBuilder getLine(String... words)
    {
        StringBuilder sb = new StringBuilder();
        if (words != null && words.length != 0)
        {
            List<String> listWords = Arrays.asList(words);
            if (listWords.contains(null) || listWords.contains(""))
            {
                return sb;
            }
            boolean finded = false;
            while (!finded)
            {
                finded = true;

                for (int i = 0; i < listWords.size() - 1; i++)
                {
                    String word1 = listWords.get(i).toLowerCase();
                    String word2 = listWords.get(i + 1).toLowerCase();
                    char ch1 = word1.charAt(word1.length() - 1);
                    char ch2 = word2.charAt(0);
                    if (ch1 != ch2)
                    {
                        finded = false;
                    }
                }

                if (!finded)
                {
                    Collections.shuffle(listWords);
                }
            }
            for (int i = 0; i < listWords.size(); i++)
            {
                sb.append(listWords.get(i) + " ");
            }
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb;
    }
}
