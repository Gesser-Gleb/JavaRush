package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри.
Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);
        Cat tomcat = new Cat("Tom", "blue", 7);
        Dog spaykdog = new Dog("Spayk", "brown", 10);
        //Напишите тут ваш код
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }
    public static class Cat {
        String name, colour;
        int age;
        public  Cat(String name, String colour, int age) {
            this.name = name;
            this.colour = colour;
            this.age = age;
        }
    }
    public static class Dog {
        String name, colour;
        int age;
        public  Dog(String name, String colour, int age) {
            this.name = name;
            this.colour = colour;
            this.age = age;
        }
    }
    //Напишите тут ваши классы

}
