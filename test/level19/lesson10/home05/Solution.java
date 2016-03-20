package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String firstFileName = args[0],
                secondFileName = args[1];
        String[] array = {"0","1","2","3","4","5","6","7","8","9"};
        BufferedReader reader = new BufferedReader(new FileReader(firstFileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(secondFileName));
        while (reader.ready()) {
            String line = reader.readLine();
            String[] s = line.split(" ");
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (s[i].contains(array[j])) {
                        writer.write(s[i] + " ");
                        break;
                    }
                }

            }
        }
        reader.close();
        writer.close();
    }
}
