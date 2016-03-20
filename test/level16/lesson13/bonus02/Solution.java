package com.javarush.test.level16.lesson13.bonus02;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);
    static {
        threads.add(new Infinity());
        threads.add(new InterruptExcep());
        threads.add(new GreatInfinity());
        threads.add(new InterruptMessage());
        threads.add(new ReadAndOutputNumber());
    }

    public static class Infinity extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }
    public static class InterruptExcep extends Thread  {
        @Override
        public void run() {
            try {
                while (!isInterrupted()){}
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class GreatInfinity extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {}
        }
    }
    public static class InterruptMessage extends Thread implements Message {
        @Override
        public void showWarning() {
            this.interrupt();
            try {
                this.join();

            } catch (InterruptedException e) {}
        }

        @Override
        public void run() {
            Thread thread = currentThread();
            while (!thread.isInterrupted()) {

            }
        }
    }
    public static class ReadAndOutputNumber extends Thread {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    String s = reader.readLine();
                    if (s.equals("N")) {
                        System.out.println(total);
                        this.interrupt();
                        continue;
                    }
                        total += Integer.parseInt(s);

                } catch (IOException e) {
                }
            }
        }
    }
}
