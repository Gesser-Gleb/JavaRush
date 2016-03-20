package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String Doggy = null;
    public void initialize(String name) {
        this.Doggy = name;
    }
    public void initialize(String name, int height) {
        this.Doggy = name + height;
    }
    public  void initialize(String name, int height, String colour) {
        this.Doggy = name + height + colour;
    }

}
