package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine(),
                secondFileName = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(firstFileName));
        List<Long> list = new ArrayList<>();
        while (fileReader.ready()) {
            String[] arrayString = fileReader.readLine().split(" ");
            for (String s :arrayString) {
                list.add(Math.round(Double.parseDouble(s)));
            }
        }
        FileWriter fw = new FileWriter(secondFileName);
        for (Long aLong :list) {
            fw.write(aLong + " ");
        }
        reader.close();
        fileReader.close();
        fw.close();

    }
}
