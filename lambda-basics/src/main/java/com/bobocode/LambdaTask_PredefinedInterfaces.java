package com.bobocode;

import com.bobocode.model.Account;

import java.util.function.Predicate;

/**
 * Here you can find a list of various predefined interface variables. Your job is to provide implementation foe each
 * variable. In the comment you can see what options do you have
 */
public class LambdaTask_PredefinedInterfaces {
    public static void main(String[] args) {

        // Predicates. As you remember Predicate<T> is a functional interface, its method test() receives one argument
        // with type T and returns boolean

        Predicate<Integer> isNegative; // check whether a value is less than zero
        Predicate<Account> useGoogle; // check whether its email ends with gmail.com
        Predicate<Integer> isPrime; // implement logic that checks whether a number is prime


    }


}
