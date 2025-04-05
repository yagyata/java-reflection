package com.bridgelabz.reflectionBasic;

import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int age;
    private int roll_number;

    Student(String name, int age, int roll_number) {
        this.name = name;
        this.age = age;
        this.roll_number = roll_number;
    }

    public void displayDetails() {
        System.out.println("Student Name: " + name + "\nAge: " + age + "\nRoll Number: " + roll_number);
    }
}

public class CreateObjectsDynamically {
    public static void main(String[] args) {
        try {
            Class<?> cls = Student.class;

            Constructor<?> studentConstructor = cls.getDeclaredConstructor(String.class, int.class, int.class);

            Student s1 = (Student) studentConstructor.newInstance("Yagyata", 21, 2110991568);

            s1.displayDetails();

        } catch (NoSuchMethodException e) {
            System.out.println("No constructor of Student class present.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
