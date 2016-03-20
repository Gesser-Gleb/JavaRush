package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Егуменов", new Date("FEBRUARY 29 1988"));
        map.put("Gudova", new Date("AUGUST 12 1985"));
        map.put("Kupone", new Date("SEPTEMBER 3 1995"));
        map.put("Lifone", new Date("MARCH 17 1970"));
        map.put("Birone", new Date("MAY 19 1977"));
        map.put("Firone", new Date("JANUARY 22 1997"));
        map.put("Hirone", new Date("APRIL 4 1935"));
        map.put("Lirone", new Date("JULY 6 1965"));
        map.put("Kirone", new Date("OCTOBER 9 1975"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
       while (iterator.hasNext()) {
           Map.Entry<String, Date> pair = iterator.next();
           if (pair.getValue().getMonth() > 4 && pair.getValue().getMonth() < 8) iterator.remove();
       }
    }

    public static void main(String[] args) {
        HashMap<String, Date> map = createMap();
        for (Map.Entry<String, Date> p : map.entrySet()) {
            System.out.println(p.getKey() + " " + p.getValue());
        }
        System.out.println();
        removeAllSummerPeople(map);
        for (Map.Entry<String, Date> p : map.entrySet()) {
            System.out.println(p.getKey() + " " + p.getValue());
        }

    }

}
