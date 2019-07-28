package com.javarush.task.task32.task3206;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ItemInvocationHandler implements InvocationHandler {
    private Object obj;

    public ItemInvocationHandler(Object obj) {
        this.obj = obj;
    }

    public ItemInvocationHandler() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(obj, args);
    }
}