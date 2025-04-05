package com.bridgelabz.reflectionIntermediate;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    private int add(int a, int b) {
        return a+b;
    }
    private int subtract(int a, int b){
        return a-b;
    }
    private int multiply(int a, int b){
        return a*b;
    }
}
public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        MathOperations operations = new MathOperations();
        Class<?> cls = operations.getClass();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the method you want to use: ");
        String methodName = sc.nextLine();

        Method method = cls.getDeclaredMethod(methodName, int.class, int.class);
        method.setAccessible(true);

        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();

        int result = (int) method.invoke(operations, num1, num2);
        System.out.println("Result: " + result);
    }
}
