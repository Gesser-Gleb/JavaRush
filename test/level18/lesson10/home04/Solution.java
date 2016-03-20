package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = reader.readLine();
        String fileNameTwo = reader.readLine();

        RandomAccessFile fileOne = new RandomAccessFile(fileNameOne, "rw");
        RandomAccessFile fileTwo = new RandomAccessFile(fileNameTwo, "r");

        byte[] bufferOne = new byte[(int) fileOne.length()];
        fileOne.read(bufferOne);

        byte[] bufferTwo =  new byte[(int) fileTwo.length()];
        fileTwo.read(bufferTwo);

        fileOne.seek(0);

        fileOne.write(bufferTwo);
        fileOne.write(bufferOne);

        fileOne.close();
        fileTwo.close();
        reader.close();
    }
}
