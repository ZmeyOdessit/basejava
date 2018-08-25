package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        // TODO : invoke r.toString via reflection
        //https://stackoverflow.com/questions/6807771/java-tostring-for-any-object
        //https://stackoverflow.com/questions/892725/proper-way-to-check-java-reflection-calls
        Class <?> rClass = r.getClass();
        Method method = rClass.getMethod("toString");
        Object result = method.invoke(r);
        System.out.println(result);
    }
}