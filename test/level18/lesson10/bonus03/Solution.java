package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        if (args.length > 0) {
            if (args[0].equals("-u")) {
                String id = spaceAdd(args[1], 8);
                String productName = "";
                for (int i = 2; i < (args.length - 2); i++) {
                    productName += args[i] + " ";
                }
                productName = spaceAdd(productName, 30);
                String price = spaceAdd(args[args.length - 2], 8);
                String quantity = spaceAdd(args[args.length - 1], 4);
                String result = id + productName + price + quantity;

                updateFile(result, fileName, id);
            }
            if (args[0].equals("-d")) {
                String id = spaceAdd(args[1], 8);

                deleteLine(fileName, id);
            }
        }
    }
    public static String spaceAdd (String s, int count) {
        String result;
        String space = "";
        if (s.length() > count) {
            result = s.substring(0, count);
        } else {
            for (int i = 0; i < (count - s.length()); i++) {
                space += " ";
            }
            result = s + space;
        }
        return result;
    }
    public static void updateFile(String s, String fileName, String id) throws IOException{
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }

        List<String> array = new ArrayList<String>();
        BufferedReader r = new BufferedReader(new FileReader(fileName));
        String stroka;

        while ((stroka = r.readLine()) != null) {
           if (stroka.substring(0, 8).equals(id)) {
                array.add(s);
           } else {
                array.add(stroka);
           }
        }
        r.close();
        PrintWriter out = new PrintWriter(fileName);
        for (String s1 : array) {
            out.println(s1);
        }
        out.close();
    }
    public static void deleteLine(String fileName, String id) throws IOException{
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }

        List<String> array = new ArrayList<String>();
        BufferedReader r = new BufferedReader(new FileReader(fileName));
        String stroka;

        while ((stroka = r.readLine()) != null) {
            if (stroka.substring(0, 8).equals(id)) {
                continue;
            } else {
                array.add(stroka);
            }
        }
        r.close();
        PrintWriter out = new PrintWriter(fileName);
        for (String s1 : array) {
            out.println(s1);
        }
        out.close();
    }
}
