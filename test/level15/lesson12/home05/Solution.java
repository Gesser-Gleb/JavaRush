package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    int i;
    String s;
    boolean b;

    public Solution() {
    }

    public Solution(int i) {
        this.i = i;
    }

    public Solution(int i, String s) {
        this.i = i;
        this.s = s;
    }

    private Solution(String s) {
        this.s = s;
    }

    private Solution(String s, int i) {
        this.s = s;
        this.i = i;
    }

    private Solution(boolean b) {
        this.b = b;
    }

    protected Solution(int i, String s, boolean b) {
        this.i = i;
        this.s = s;
        this.b = b;
    }

    protected Solution(String s, boolean b) {
        this.s = s;
        this.b = b;
    }

    protected Solution(int i, boolean b) {
        this.i = i;
        this.b = b;
    }

    Solution(Object o){

    }

    Solution(Object o, int c) {

    }

    Solution(int c, Object o) {

    }
}

