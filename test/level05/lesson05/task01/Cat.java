package com.javarush.test.level05.lesson05.task01;

/* Создать класс Cat
Создать класс Cat. У кота должно быть имя (name, String), возраст (age, int), вес (weight, int), сила (strength, int).
*/

public class Cat {
    public String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int age;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public  int weight;
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public  int strength;
    public  int getStrength() {
        return strength;
    }

    public void setStrength(int strength)
    {
        this.strength = strength;
    }
}

