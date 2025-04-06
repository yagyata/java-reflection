package com.bridgelabz.intermediateLevel;

import java.lang.reflect.Field;

class Configuration{
    private static String API_KEY = "apiKey";
}

public class ModifyStaticFields {
    public static void main(String[] args) throws Exception {
        Configuration config = new Configuration();
        Class<?> c = config.getClass();

        Field f = c.getDeclaredField("API_KEY");
        f.setAccessible(true);
        System.out.println("Before Modifying, Value: " + f.get(Configuration.class));

        f.set(Configuration.class, "apiKeyChanged");
        System.out.println("After Modifying, Value: : " + f.get(Configuration.class));
    }
}
