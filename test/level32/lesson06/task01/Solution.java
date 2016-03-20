package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword()
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        byte[] mas = letters.getBytes();
        List<Byte> list = new ArrayList<>();
        Random random = new Random();
        while (true)
        {
            for (int i = 0; i < 8; i++) {
                if (i%2==0) {
                    int k = random.nextInt(letters.length() - 1);
                    list.add(mas[k]);
                }
                else
                {
                    if (i==1)
                        list.add(mas[ new Random().nextInt(25)]);
                    if (i==3)
                    {
                        int n = new Random().nextInt(51);
                        if (n>25)
                            list.add(mas[n]);
                        else
                            list.add(mas[n+26]);
                    }

                    if (i==5)
                    {
                        int n = new Random().nextInt(9);
                        list.add(mas[letters.length() - 1 -n]);
                    }

                    if (i==7)
                        list.add(mas [new Random().nextInt(letters.length() - 1)]);
                }
            }
            //System.out.println(list);
            if (isValid(list))
                break;
            list.clear();
        }
        //byte[] mas = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            //mas[i] = list.get(i);
            baos.write(list.get(i));
        }

        return baos;
    }


    public static boolean isValid (List<Byte> list) {
        int k = 0;
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i)==list.get(j)) {
                    k++;
                    break;
                }
            }
        }
        //System.out.println(k);
        if (k==0)
        {
            return true;
        }
        else
            return false;

    }
}
