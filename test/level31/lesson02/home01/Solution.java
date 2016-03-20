package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.*;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {


    public static void main(String[] args) throws IOException {
        if (args.length < 2)
            return;
        String path = args[0];
        String resultFileAbsolutePath = args[1];


//        String path = "C:\\A";
//        String resultFileAbsolutePath = "C:\\A\\D\\result.txt";

        Solution solution = new Solution();

        List<File> list =  solution.method(path, new ArrayList<File>());;

        //System.out.println(list);

        solution.write(list, resultFileAbsolutePath);
        solution.delete(path);

    }

    public void delete (String path) {
        File file = new File(path);

        for (File it: file.listFiles())
        {
            if (it.isDirectory())
            {
                if (it.listFiles().length==0)
                {
                    it.delete();
                }
                else
                {
                    delete(it.getPath());
                }
            }

        }
    }


    public void write (List<File> list, String resultFile) throws IOException {

        Collections.sort(list, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        //System.out.println(list);
        File file1 = new File(resultFile);
        File file2 = new File(file1.getParent() + "/allFilesContent.txt");
        file1.renameTo(file2);

        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));

        for (File it: list)
        {
            if (!it.equals(file1)) {
                BufferedReader br = new BufferedReader(new FileReader(it));

                String s;
                while ((s = br.readLine()) != null) {
                    //System.out.println(s);
                    bw.write(s);
                    bw.newLine();
                }


                br.close();
            }

        }
        bw.close();
    }

    public List<File> method(String path, List<File> list)
    {
        File file = new File(path);

        for (File it: file.listFiles())
        {
            if (it.isFile())
            {
                if (it.length()>50)
                {
                    it.delete();
                }
                else
                {
                    list.add(it);
                }
            }
            else
            {
                method(it.getPath(), list);
            }
        }

        return list;
    }
}