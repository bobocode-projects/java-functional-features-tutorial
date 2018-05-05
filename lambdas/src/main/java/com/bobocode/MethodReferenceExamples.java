package com.bobocode;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * A list of method reference examples.
 */
public class MethodReferenceExamples {
    public static void main(String[] args) {
        printAbsUsingMethodReference(-23);
        printSumUsingMethodReference(25, 50);
    }

    private static void printAbsUsingMethodReference(int a) {
        Function<Integer, Integer> absFunction = Math::abs;
        int result = absFunction.apply(a);

        System.out.println("abd(" + a + ") = " + result);
    }

    private static void printSumUsingMethodReference(int a, int b) {
        BiFunction<Integer, Integer, Integer> sumFunction = Math::addExact;
        int result = sumFunction.apply(a, b);

        System.out.println(a +" + "+ b + " = " + result);
    }


}
