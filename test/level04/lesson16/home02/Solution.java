package com.javarush.test.level04.lesson16.home02;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader r = new BufferedReader (new InputStreamReader(System.in));
        String n1 = r.readLine(), n2 = r.readLine(), n3 = r.readLine();
        int in1 = Integer.parseInt(n1), in2 = Integer.parseInt(n2), in3 = Integer.parseInt(n3);
        if ((in1 > in2 & in1 > in3 & in2 < in3) || (in1 < in2 & in1 < in3 & in2 > in3))
            System.out.println(in3);
        else if ((in2 > in3 & in2 > in1 & in3 < in1) || (in2 < in3 & in2 < in1 & in3 > in1))
            System.out.println(in1);
        else
            System.out.println(in2);

    }
}
