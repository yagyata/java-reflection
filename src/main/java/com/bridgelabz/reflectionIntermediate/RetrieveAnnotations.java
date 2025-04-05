package com.bridgelabz.reflectionIntermediate;

import java.lang.annotation.*;

import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Author {
    String authorName();
}

class Test {
    @Author(authorName = "Jane Austen")
    public void method(){}
}
public class RetrieveAnnotations {
    public static void main(String[] args) throws Exception {
        Test test = new Test();
        Class<?> cls = test.getClass();

        Method method = cls.getMethod("method");

        if(method.isAnnotationPresent(Author.class)) {
            Author author = method.getAnnotation(Author.class);
            System.out.println("Author's Name: " + author.authorName());
        }

        method.invoke(test);
    }
}
