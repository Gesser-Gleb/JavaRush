package com.javarush.test.level24.lesson02.home01;

/**
 * Created by gesse_000 on 01.09.2015.
 */
public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
    public SelfInterfaceMarkerImpl() {
    }
    public void print() {
        System.out.println("Print method");
    }
    public int increment(int a) {
        return a++;
    }
}
