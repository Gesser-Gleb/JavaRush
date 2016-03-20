package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        List<String> list = new ArrayList<>();
        while (reader.ready()) {
            list.add(reader.readLine());
        }
        List<String> decoderList = new ArrayList<>();
        for (String s : list) {
            decoderList.add(new String(s.getBytes("Windows-1251")));
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        for (String s :decoderList) {
            writer.write(s);
        }
        reader.close();
        writer.close();
    }

}
