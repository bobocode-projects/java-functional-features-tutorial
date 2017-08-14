package com.bobocode;

import com.bobocode.model.Account;

import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Here you can find a list of various predefined interface variables. Your job is to provide implementation foe each
 * variable. In the comment you can see what options do you have
 */
public class LambdaTask_PredefinedInterfaces {
    public static void main(String[] args) {

        // Predicates. As you remember Predicate<T> is a functional interface, its method test() receives one argument
        // with type T and returns boolean

        // check whether a value is less than zero
        Predicate<Integer> isNegative = n -> n < 0;
        // check whether its email ends with gmail.com
        Predicate<Account> useGoogle = a -> a.getEmail().endsWith("gmail.com");

        // implement logic that checks whether a number is prime
        Predicate<Integer> isPrime = n -> IntStream.range(2, n).noneMatch(i -> n % i == 0);

        IntStream.range(1, 50)
                .forEach(i -> System.out.printf("%3d %10s\n", i, (isPrime.test(i) ? " is prime":"")));

    }


}
