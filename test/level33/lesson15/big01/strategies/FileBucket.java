package com.javarush.test.level33.lesson15.big01.strategies;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by gesse_000 on 03.03.2016.
 */
public class FileBucket {
    Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(null, null);
            path.toFile().deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getFileSize() {
        long size = 0;
        try {
            size = Files.size(path);
            return size;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return size;
    }

    public void putEntry(Entry entry) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toFile()));
            oos.writeObject(entry);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Entry getEntry() {
        if (getFileSize() == 0) return null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()));
            Entry entry = (Entry)ois.readObject();
            ois.close();
            return entry;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
