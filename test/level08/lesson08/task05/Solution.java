package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Egumenov","Gleb");
        map.put("Egumenov1","Gleb");
        map.put("Egumenov12","Gleb12");
        map.put("Egumenov123","Gleb123");
        map.put("Egumenov2","Gleb2");
        map.put("Egumenov23","Gleb2");
        map.put("Egumenov234","Gleb234");
        map.put("Egumenov3","Gleb3");
        map.put("Egumenov34","Gleb34");
        map.put("Egumenov345","Gleb345");
        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
       HashMap<String, String> map2 = new HashMap<String, String>(map);
       HashMap<String, String> map3 = new HashMap<String, String>(map);
        for (Map.Entry<String, String> stringStringEntry : map2.entrySet()) {
            map3.remove(stringStringEntry.getKey());
            if (map3.containsValue(stringStringEntry.getValue())) {
                removeItemFromMapByValue(map, stringStringEntry.getValue());
            }
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }


}
