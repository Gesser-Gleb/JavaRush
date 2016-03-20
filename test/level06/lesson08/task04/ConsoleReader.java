package com.javarush.test.level06.lesson08.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() – читает с клавиатуры строку
int readInt() – читает с клавиатуры число
double readDouble() – читает с клавиатуры дробное число
void readLn() – ждет нажатия enter [использовать readString()]
*/

public class ConsoleReader
{
    public static String readString() throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        return s;

    }

    public static int readInt() throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(r.readLine());
        return i;
    }

    public static double readDouble() throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        double d = Double.parseDouble(r.readLine());
        return d;
    }

    public static void readLn() throws Exception
    {
            ConsoleReader.readString();

    }
}
