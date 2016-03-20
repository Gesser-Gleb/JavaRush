package com.javarush.test.level13.lesson11.home03;
import java.io.*;
/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        InputStream inputStream = new FileInputStream(filename);


        while (inputStream.available()>0){
            System.out.print((char)inputStream.read());
        }


        inputStream.close();
        reader.close();
    }
}
