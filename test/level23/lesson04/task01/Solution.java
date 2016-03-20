package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution firstSol = new Solution();
        firstSol.innerClasses[0] = firstSol.new InnerClass();
        firstSol.innerClasses[1] = firstSol.new InnerClass();

        Solution secondSol = new Solution();
        secondSol.innerClasses[0] = secondSol.new InnerClass();
        secondSol.innerClasses[1] = secondSol.new InnerClass();

        Solution[] array = {firstSol, secondSol};

        return array;
    }
}
