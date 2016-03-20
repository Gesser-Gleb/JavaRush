package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(this.fileName, true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }


    public static void main(String[] args) throws Exception {
        Solution sol = new Solution("C:\\Users\\gesse_000\\Desktop\\test.txt");
        sol.writeObject("solution1");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\gesse_000\\Desktop\\test.txt"));
        oos.writeObject(sol);
        sol.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\gesse_000\\Desktop\\test.txt"));
        Solution sol2 = (Solution)ois.readObject();
        sol2.writeObject("hi");
        sol2.close();

        System.out.println(String.valueOf(sol).equals(String.valueOf(sol2)));
        System.out.println(sol);
        System.out.println(sol2);
    }
}
