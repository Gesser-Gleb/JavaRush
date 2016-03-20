package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String cotya = null;
    int ves;
    int sAge;
    public void initialize(String name) {
        this.cotya = name;
    }
    public void initialize(String name, int weight, int age) {
        this.cotya = name + age;
    }
    public  void initialize(String name, int age) {
        this.cotya = name + age + ves;
    }
    public void initialize(int weight, String colour) {
        this.cotya = weight + colour + sAge;
    }
    public  void  initialize(int weight, String colour, String adres) {
        this.cotya = weight + colour + adres;
    }
}
