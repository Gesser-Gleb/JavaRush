package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {

  //  private static final long serialVersionUID = 1L;
    public static class A {
        public A() {}
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
        private void writeObject(ObjectOutputStream out) throws IOException {
            out.writeObject(name);
        }
        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            name = (String)ois.readObject();
        }
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("C:\\Users\\gesse_000\\Desktop\\serialize.txt"));
        Solution s = new Solution();
        Solution.B b = s.new B("l");
        oos.writeObject(b);
        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("C:\\Users\\gesse_000\\Desktop\\serialize.txt"));
        B b2 = (B)ois.readObject();
        System.out.println(String.valueOf(b).equals(String.valueOf(b2)));
        System.out.println(b);
        System.out.println(b2);
    }
}
