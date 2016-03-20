package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String firstFileName = args[0],
                secondFileName = args[1];
        BufferedReader fileReader = new BufferedReader(new FileReader(firstFileName));
        PrintWriter writer = new PrintWriter(secondFileName);
        String result = "";
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] words = line.split(" ");
            for (String s : words) {
                if (s.length() > 6) {
                    result += s + ",";
                }
            }
        }
        writer.print(result.substring(0, result.lastIndexOf(",")));
        fileReader.close();
        writer.close();
    }
}
