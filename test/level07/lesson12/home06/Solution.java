package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> family = new ArrayList<Human>();

        Human grFath = new Human("Petya", true, 75, null, null);
        Human grMoth = new Human("Vera", false, 75, null, null);
        Human grFath2 = new Human("Vasya", true, 70, null, null);
        Human grMoth2 = new Human("Lyuda", false, 70, null, null);
        Human Father = new Human("George", true, 50, grFath, grMoth);
        Human Mother = new Human("Fiona",false, 50, grFath2, grMoth2);
        Human child1 = new Human("Shino", true, 30, Father, Mother);
        Human child2 = new Human("Kibo", true, 32, Father, Mother);
        Human child3 = new Human("Hinata", false, 23, Father, Mother);
        family.add(grFath);
        family.add(grMoth);
        family.add(grFath2);
        family.add(grMoth2);
        family.add(Father);
        family.add(Mother);
        family.add(child1);
        family.add(child2);
        family.add(child3);
        for (int i = 0; i < family.size(); i++) {
            System.out.println(family.get(i));
        }

    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;
        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
