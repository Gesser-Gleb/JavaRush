package com.javarush.test.level18.lesson10.home08;

import java.util.HashMap;
import java.util.Map;
import java.io.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {

            while (true) {
                String s = reader.readLine();
                if (s.equals("exit")) break;
                new ReadThread(s).start();
            }
            reader.close();
        } catch (Exception e) {}


    }

    public static class ReadThread extends Thread {
        String filename;
        public ReadThread(String fileName) {
            this.filename = fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(filename);
                Map<Integer, Integer> map = new HashMap<>();
                while (fis.available() > 0) {
                    int count = 1;
                    int data = fis.read();
                    if (map.containsKey(data)){
                        map.put(data, map.get(data) + 1);
                    } else {
                        map.put(data, count);
                    }
                }
                int temp = 0;
                int result = 0;
                for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
                    if (entry.getValue() > temp) {
                        temp = entry.getValue();
                        result = entry.getKey();
                    }
                }
                if (temp > 0) resultMap.put(filename, result);

                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("File not found!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
