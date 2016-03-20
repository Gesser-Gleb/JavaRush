package com.javarush.test.level34.lesson08.bonus01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if (cache.get(key) == null) {
            cache.put(key, clazz.getConstructor(key.getClass()).newInstance(key));
        }
        return cache.get(key);
    }

    public boolean put(V obj) {
        try {
            Method method = obj.getClass().getMethod("getKey");
            method.setAccessible(true);
            K key = (K) method.invoke(obj);
            cache.put(key, obj);
            if (cache.containsKey(key))
                return true;
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
        }

        return false;
    }

    public int size() {
        return cache.size();
    }
}
