package com.javarush.test.level34.lesson02.task01;

/* Числа Фибоначчи с помощью рекурсии
Почитать про числа Фибоначчи.
Реализовать логику метода fibonacci, где n - это номер элемента в последовательности Фибоначчи.
Не создавайте статические переменные и поля класса.
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.rightFibonacci(9));     //34
      //  System.out.println(solution.fibonacci(5));     //5
       // System.out.println(solution.fibonacci(2));     //1
       // System.out.println(solution.fibonacci(1));     //1
    }

    public int rightFibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) {
            return 1;
        }
        else {
           // System.out.println(1);
            int x0 = 0,
                    x1 = 1,
                    x2 = 1;
            for (int i = 0; i < n - 1; i++) {
                x2 = x0 + x1;
                x0 = x1;
                x1 = x2;
               // System.out.println(x2); - для вывода ряда фибоначчи
            }
            return x2;
        }
    }

    public int fibonacci(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        return fibonacci(n - 2) + fibonacci(n - 1);

    }
}
