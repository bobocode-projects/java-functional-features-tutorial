package com.bobocode;

import java.util.function.*;

/**
 * A list of method reference examples.
 */
public class MethodReferenceExamples {
    public static void main(String[] args) {
        printAbsUsingMethodReference(-23);
        printSumUsingMethodReference(25, 50);
        printUpperStringUsingMethodReference("Lambda is awesome!");
    }

    private static void printAbsUsingMethodReference(int a) {
        IntUnaryOperator absOperator = Math::abs;
        int result = absOperator.applyAsInt(a);

        System.out.println("abs(" + a + ") = " + result);
    }

    private static void printSumUsingMethodReference(int a, int b) {
        IntBinaryOperator sumOperator = Math::addExact;
        int result = sumOperator.applyAsInt(a, b);

        System.out.println("\n" + a + " + " + b + " = " + result);
    }

    private static void printUpperStringUsingMethodReference(String s) {
        UnaryOperator<String> upperOperation = String::toUpperCase;

        System.out.println("\n" + s + " -> " + upperOperation.apply(s));
    }

}
