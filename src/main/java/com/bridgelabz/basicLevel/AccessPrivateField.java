package com.bridgelabz.basicLevel;

import java.lang.reflect.Field;

class Person {
    private int age = 20;
}

public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class<?> cls = person.getClass();

        Field field = cls.getDeclaredField("age");
        field.setAccessible(true);

        System.out.println("Before Modifying: Age = " + field.get(person));

        //Modifying the value
        field.set(person, 21);

        //Retrieving the value
        System.out.println("After Modifying: Age = " + field.get(person));
    }
}
