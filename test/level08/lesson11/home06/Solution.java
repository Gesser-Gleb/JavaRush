package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> kids = new ArrayList<Human>();
        kids.add(new Human("Gleb", true, 27, new ArrayList<Human>()));
        kids.add(new Human("Vera", false, 30, new ArrayList<Human>()));
        kids.add(new Human("Tanya", false, 26, new ArrayList<Human>()));

        ArrayList<Human> father = new ArrayList<Human>();
        father.add(new Human("Vasya", true, 55, kids));

        ArrayList<Human> mother = new ArrayList<Human>();
        mother.add(new Human("Lena", false, 52, kids));

        ArrayList<Human> grand = new ArrayList<Human>();
        grand.add(new Human("Petya", true, 75, father));
        grand.add(new Human("Masha", false, 72, father));
        grand.add(new Human("Sasha", true, 74, mother));
        grand.add(new Human("Sveta", false, 73, mother));

        ArrayList<Human> family = new ArrayList<Human>(grand);
        family.addAll(mother);
        family.addAll(father);
        family.addAll(kids);
        for (Human human : family) {
            System.out.println(human);
        }

    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;
        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;

        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
