package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            String s = r.readLine();
            if (s.equals("end")) break;
            list.add(s);
        }

        Collections.sort(list);
        String st = list.get(0);
        FileOutputStream out = new FileOutputStream(st.substring(0, st.indexOf(".part")));

        for(String s : list)
        {
            FileInputStream in = new FileInputStream(s);
            byte []bytes = new byte[in.available()];
            in.read(bytes);
            out.write(bytes);
            in.close();
        }

        out.close();
        r.close();
    }
}
