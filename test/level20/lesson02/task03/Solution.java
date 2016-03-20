package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    Properties prop = new Properties();

    public static void main(String[] args) throws Exception {
    new Solution().fillInPropertiesMap();
        System.out.println(properties);
    }

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        InputStream input = new FileInputStream(fileName);
        load(input);
        reader.close();

        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            prop.setProperty(entry.getKey(), entry.getValue());
        }
        prop.store(outputStream, null);
        outputStream.close();

        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        prop.load(inputStream);
        for (String s : prop.stringPropertyNames()) {
            properties.put(s, prop.getProperty(s));
        }
        inputStream.close();
        //implement this method - реализуйте этот метод
    }
}
