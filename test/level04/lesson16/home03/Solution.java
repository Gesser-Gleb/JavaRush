package com.javarush.test.level04.lesson16.home03;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.
-1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        while (true)
        {
            String n = r.readLine();
            int in = Integer.parseInt(n);
            sum += in;
            if (in == (-1))
            {
                System.out.println(sum);
                break;
            }
        }
    }
}
