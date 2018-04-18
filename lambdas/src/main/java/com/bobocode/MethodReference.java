package com.bobocode;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by taras on 8/11/17.
 */
public class MethodReference {
    public static void main(String[] args) {
        // 1 - method reference to static method
        Function<Integer, Integer> absFunction = Math::abs;

        int a = 5;

        Function<Integer, Integer> f;

        // 2 - methods reference to instance method
        String hello = "Hello";
        Supplier<String> helloUppercaseSupplier = hello::toUpperCase;
        doSomethingWithStringSupplier(helloUppercaseSupplier);

        // 3 - special case (ClassName::objMethodName)
        Function<String, String> toUpperCase = String::toUpperCase;
        toUpperCase.apply("hello");
    }

    static void doSomethingWithStringSupplier(Supplier<String> stringSupplier) {

    }

    static String computeSomething() {
        // some operation
        return "hello";
    }

    static void processSomething(String s) {

    }
}
