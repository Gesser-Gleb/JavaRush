package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        private String name, placeOfBirth;
        private int age, passportNumber;
        private boolean sex, maritalStatus;

        public Human(
                String name, String placeOfBirth, int age, int passportNumber, boolean sex, boolean maritalStatus) {
            this.name = name;
            this.placeOfBirth = placeOfBirth;
            this.age = age;
            this.passportNumber = passportNumber;
            this.sex = sex;
            this.maritalStatus = maritalStatus;
        }
        public Human(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }
        public Human(String name) {
            this.name = name;
        }
        public Human(String name, int passportNumber) {
            this.name = name;
            this.passportNumber = passportNumber;
        }
        public Human(boolean sex, boolean maritalStatus) {
            this.sex = sex;
            this.maritalStatus = maritalStatus;
        }
        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        public Human(int age, String placeOfBirth) {
            this.age = age;
            this.placeOfBirth = placeOfBirth;
        }
        public Human(String name, String placeOfBirth) {
            this.name = name;
            this.placeOfBirth = placeOfBirth;
        }
        public Human(boolean maritalStatus) {
            this.maritalStatus = maritalStatus;
        }
        public Human(int passportNumber) {
            this.passportNumber = passportNumber;
        }
        //напишите тут ваши переменные и конструкторы
    }
}
