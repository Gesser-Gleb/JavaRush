package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id
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
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        String productName = "";

        for (int i = 1; i < args.length-2; i++)
            productName = productName + args[i] + " ";
        String trueProductName = setSpaces(productName, 30);

        String truePrice = setSpaces(args[args.length-2], 8);
        String trueQuantity = setSpaces(args[args.length-1], 4);

        String id = getId(fileName);
        id = setSpaces(id, 8);
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
        printWriter.println(id + trueProductName + truePrice + trueQuantity);
        printWriter.close();

    }

    public static String getId (String fileName) throws IOException {
        ArrayList<Long> allIds = new ArrayList<Long>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        Long currentId;
        while ((line=bufferedReader.readLine()) != null) {
            line = line.substring(0, 8).replaceAll("\\s", "");
            currentId = Long.parseLong(line);
            allIds.add(currentId);
        }
        bufferedReader.close();
        Long maxId = Collections.max(allIds);
        Long MyId = maxId+1;
        return MyId.toString();
    }


    public static String setSpaces (String previousName, int count) {
        String trueName;
        if (previousName.length()>count)
            trueName = previousName.substring(0, count);
        else
        {
            String s="";
            for (int i = 0; i < (count  - previousName.length()); i++)
                s = s+ " ";
            trueName = previousName+s;
        }
        return trueName;
    }
}

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class Solution {
    public static void main(String[] args) throws Exception {
        if(args[0].equals("-c")) {
            long id = -1;
            String productName = args[1];
            String price = args[2];
            String quantity = args[3];
            String res = "";
            //форматирую текст
            productName = formatText(productName, 30);
            price = formatText(price, 8);
            quantity = formatText(quantity, 4);
            //генерирую айдишник
            BufferedReader readFile = new BufferedReader(new FileReader("D:/1.txt"));
            String linesInFile;
            while((linesInFile = readFile.readLine()) != null) {
                String idStrTmp = linesInFile.substring(0, 8);
                String idStr = "";
                char[] idCh = idStrTmp.toCharArray();
                for(char c : idCh) {
                    if(c != ' ' && c != '\uFEFF')
                        idStr+=c;
                }
                long tmpId = Long.parseLong(idStr);
                if(tmpId > id) {
                    id = tmpId;
                }
            }
            id+=1;
            String idStr = "" + id;
            idStr = formatText(idStr, 8);
            readFile.close();
            res = idStr + productName + price + quantity;
            //записываю в файл
            BufferedWriter writeFile = new BufferedWriter(new FileWriter("D:/1.txt", true));
            if(id > 0)
            writeFile.newLine();
            writeFile.write(res);
            writeFile.close();
        }
    }
    public static String formatText(String in, int length) {
        String res="";
        if(in.length() >= length)
        {
            res = in.substring(0, length);
        }
        else if(in.length() < length){
                res+= in;
            for(int i = 0; i < length - in.length(); i++)
                res+=" ";
        }
        return res;
    }
}
 */