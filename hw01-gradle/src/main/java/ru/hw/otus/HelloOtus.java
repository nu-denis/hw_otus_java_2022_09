package ru.hw.otus;

import com.google.common.collect.ImmutableMap;

public class HelloOtus {
    public static void main(String... args) {
        ImmutableMap<String, String> immutableMap = ImmutableMap.of("Hello", "OTUS");
        System.out.println(immutableMap);
    }
}
