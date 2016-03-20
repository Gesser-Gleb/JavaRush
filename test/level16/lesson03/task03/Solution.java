package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread specialThread = new SpecialThread();
        Thread thread  = new Thread(specialThread);
        Thread thread1 = new Thread(specialThread);
        Thread thread2 = new Thread(specialThread);
        Thread thread3 = new Thread(specialThread);
        Thread thread4 = new Thread(specialThread);
        list.add(thread);
        list.add(thread1);
        list.add(thread2);
        list.add(thread3);
        list.add(thread4);
        //Add your code here - добавьте свой код тут
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
