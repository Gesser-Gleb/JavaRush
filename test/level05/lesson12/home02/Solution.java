package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man1 = new Man("Gleb", 27, "Kemerovo");
        Man man2 = new Man("Max", 22, "Moskva");
        Woman w1 = new Woman("Olya", 29, "Moskva");
        Woman w2 = new Woman("Milana", 32, "Kemerovo");
        // Создай по два объекта каждого класса тут
        System.out.println(man1);
        System.out.println(man2);
        System.out.println(w1);
        System.out.println(w2);
        // Выведи их на экран тут

    }

    public static class Man {
        private String name, address;
        private int age;
        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        @Override
        public String toString() {
            return this.name + " " + this.age + " " + this.address;
        }
    }
    public static class Woman {
        private String name, address;
        private int age;
        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        @Override
        public String toString() {
            return this.name + " " + this.age + " " + this.address;
        }
    }
    // Напиши тут свои классы
}
