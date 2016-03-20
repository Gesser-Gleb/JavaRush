package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {

        final double mediana;
        Arrays.sort(array);
        if (!(array.length % 2 == 0)) {
            mediana = array[(array.length - 1)/2];
        } else {
            mediana = ((array[(array.length - 1 )/ 2]) + array[(array.length - 1) / 2 + 1]) / 2;
        }
        Comparator<Integer> compIntAr = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return (int)(Math.abs(mediana - o1) - Math.abs(mediana - o2));
            }
        };
        Arrays.sort(array, compIntAr);

        return array;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{3,5,0,6,10,7,2};
        sort(a);
        for (Integer integer :a) {
            System.out.println(integer);
        }

    }
}
