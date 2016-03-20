package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/
import java.io.*;


public class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sFirst = reader.readLine();
        String sSecond = reader.readLine();
        int first = Integer.parseInt(sFirst);
        int second = Integer.parseInt(sSecond);
        int nod = 0;
        if (first < second) {
            for (int i = 1; i <= first ; i++) {
                if (first % i == 0 && second % i == 0) nod = i;
            }
        }
        else for (int i = 1; i <= second; i++) {
            if (first % i == 0 && second % i == 0) nod = i;
        }
        System.out.println("Наибольший общий делитель чисел " + first + " и " + second + " = " + nod);

    }
}

