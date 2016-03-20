package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File file = new File(root);
        List<String> result = new ArrayList<>();
        Queue<File> queue =  new ArrayDeque<>();

        Collections.addAll(queue, file.listFiles());
        while (!queue.isEmpty()) {
            File fq = queue.poll();
            if (fq.isDirectory())
                Collections.addAll(queue, fq.listFiles());
            else
                result.add(fq.getAbsolutePath());
        }
        return result;
    }
}
