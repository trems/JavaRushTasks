package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V returnedVal = cache.get(key);
        if (returnedVal != null)
            return returnedVal;
        else {
            V newValue = clazz.getDeclaredConstructor((key.getClass())).newInstance(key);
            cache.put(key, newValue);
            return newValue;
        }
    }

    public boolean put(V obj) {
        //TODO add your code here
        Method getKey = null;
        try {
            getKey = obj.getClass().getDeclaredMethod("getKey");
            getKey.setAccessible(true);
            cache.put((K) getKey.invoke(obj), obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
