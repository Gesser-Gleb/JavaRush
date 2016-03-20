package com.javarush.test.level31.lesson06.home01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) return;

        Path fullPathToFile = Paths.get(args[0]);
        Path fullPathToZip = Paths.get(args[1]);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        List<Path> archiveFiles = new ArrayList<>();

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream)) {
            try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(fullPathToZip))) {

                ZipEntry zipEntry = zipInputStream.getNextEntry();
                while (zipEntry != null) {
                    String fileName = zipEntry.getName();
                    archiveFiles.add(Paths.get(fileName));

                    zipOutputStream.putNextEntry(new ZipEntry(fileName));
                    byte[] buffer = new byte[8 * 1024];
                    int len;
                    while ((len = zipInputStream.read(buffer)) > 0) {
                        zipOutputStream.write(buffer, 0, len);
                    }

                    zipInputStream.closeEntry();
                    zipOutputStream.closeEntry();

                    zipEntry = zipInputStream.getNextEntry();
                }
            }

            if (archiveFiles.contains(fullPathToFile.getFileName())) {
                try (InputStream inputStream = Files.newInputStream(fullPathToFile)) {
                    ZipEntry entry = new ZipEntry(fullPathToFile.getFileName().toString());
                    zipOutputStream.putNextEntry(entry);
                    byte[] buffer = new byte[8 * 1024];
                    int len;
                    while ((len = inputStream.read(buffer)) > 0) {
                        zipOutputStream.write(buffer, 0, len);
                    }
                    zipOutputStream.closeEntry();
                }
            }
            else {
                try (InputStream inputStream = Files.newInputStream(fullPathToFile)) {
                    ZipEntry entry = new ZipEntry("new/" + fullPathToFile.getFileName().toString());
                    zipOutputStream.putNextEntry(entry);
                    byte[] buffer = new byte[8 * 1024];
                    int len;
                    while ((len = inputStream.read(buffer)) > 0) {
                        zipOutputStream.write(buffer, 0, len);
                    }
                    zipOutputStream.closeEntry();
                }
            }
        }
    }
}
