package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(1.4,"k");
        labels.put(1.5,"r");
        labels.put(1.6,"l");
        labels.put(1.7,"a");
        labels.put(1.8,"q");

    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
