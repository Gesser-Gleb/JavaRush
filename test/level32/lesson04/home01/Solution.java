package com.javarush.test.level32.lesson04.home01;

import java.io.*;

/* Читаем из потока
Реализуйте логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();

        if (is == null)
        {
            return sw;
        }
        else {

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            char[] cbuf = new char[512];
            while (reader.ready()) {
                int len = reader.read(cbuf);
                sw.write(cbuf, 0, len);
            }
            sw.close();
            return sw;
        }
    }
}
