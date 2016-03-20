package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            int countSymbol = 0;
            int countSpace = 0;
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                countSymbol++;
                if (data == 32) {
                    countSpace++;
                }
            }
            double result = (double)countSpace/countSymbol*100;
            result = new BigDecimal(result).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
            System.out.println(result);
            fileInputStream.close();
        }
    }
}
