package com.javarush.test.level05.lesson12.home05;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        String s = "";

        while (true)
        {
            String s1 = r.readLine();
            if (s1.equals("сумма"))
            {
                System.out.println(sum);
                break;
            }
            else
            {
                int is1 = Integer.parseInt(s1);
                sum += is1;
            }
        }
    }

}
