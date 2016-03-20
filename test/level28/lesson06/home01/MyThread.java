package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gesse_000 on 05.10.2015.
 */
public class MyThread extends Thread {
    static AtomicInteger i = new AtomicInteger(1);


    public MyThread(String name) {
        super(name);
        if (i.get() < 10) {
            setPriority(i.getAndIncrement());
        } else {
            setPriority(i.get());
            i.set(1);
        }
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (i.get() < 10) {
            setPriority(i.getAndIncrement());
        } else {
            setPriority(i.get());
            i.set(1);
        }


    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if (i.get() < 10) {
            setPriority(i.getAndIncrement());
        } else {
            setPriority(i.get());
            i.set(1);
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (i.get() < 10) {
            setPriority(i.getAndIncrement());
        } else {
            setPriority(i.get());
            i.set(1);
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (i.get() < 10) {
            setPriority(i.getAndIncrement());
        } else {
            setPriority(i.get());
            i.set(1);
        }
    }

    public MyThread() {

        if (i.get() < 10) {
            setPriority(i.getAndIncrement());
        } else {
            setPriority(i.get());
            i.set(1);
        }
    }

    public MyThread(Runnable target) {
        super(target);
        if (i.get() < 10) {
            setPriority(i.getAndIncrement());
        } else {
            setPriority(i.get());
            i.set(1);
        }
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (i.get() < 10) {
            setPriority(i.getAndIncrement());
        } else {
            setPriority(i.get());
            i.set(1);
        }
    }

}
