package com.javarush.test.level08.lesson08.task03;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> mapNameSurname = new HashMap<String, String>();
        mapNameSurname.put("Egumenov","Gleb");
        mapNameSurname.put("Gudova","Olya");
        mapNameSurname.put("Gudovaa","Taya");
        mapNameSurname.put("Egumenova","Milana");
        mapNameSurname.put("Egumenovaa","Larisa");
        mapNameSurname.put("Egumenovv","Sergey");
        mapNameSurname.put("Demchenko","Valya");
        mapNameSurname.put("Demchenkoo","Gena");
        mapNameSurname.put("Kuleshov","Kolya");
        mapNameSurname.put("Kuleshova","Katya");

        return mapNameSurname;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String value = pair.getValue();
            if (value.equals(name)) count++;
        }
        return count;
        

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int count2 = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String key = pair.getKey();
            if (key.equals(familiya)) count2++;
        }
        return count2;
    }

}
