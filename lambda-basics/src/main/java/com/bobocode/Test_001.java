package com.bobocode;


import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test_001 {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Hello");
        Printer printer = s -> System.out.println(s);
        Func<Integer> doubler = n -> 2 * n;

        BiFunc<Integer> sum = (a, b) -> a + b;

        Upperface upperface = String::toUpperCase;

        Predicate<Integer> isMoreThanFive = n -> n > 5;


        Function<Integer, Integer> square = n -> n * n;
        Function<Integer, Integer> increment = n -> n + 1;

        System.out.println(square.compose(increment).apply(5));

    }

    interface Printer {
        void print(String text);
    }

    interface Func<T> {
        T apply(T element);
    }

    interface BiFunc<T> {
        T apply(T elem1, T elem2);
    }

    interface Upperface {
        String apply(String s);
    }

}
