package com.bobocode;

import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * A list of predefined interfaces examples.
 */
public class PredefinedInterfacesExamples {
    public static void main(String[] args) {

        printEmailUsingAccountConsumer();

        printARandomNumberUsingIntegerSupplier();

        calculate3xValueUsingIntegerFunction();

        checkIfNumberIsPositiveUsingIntegerPredicate();

        verifyGoogleEmailUsingAccountPredicate();

        printPrimeNumbersUsingIntegerPredicate();

    }

    private static void printARandomNumberUsingIntegerSupplier() {
        Supplier<Integer> integerSupplier = () -> new Random().nextInt(1000);

        System.out.println("Next value: " + integerSupplier.get());
    }

    private static void printEmailUsingAccountConsumer() {
        Consumer<Account> accountConsumer = acc -> System.out.println(acc.getEmail());
        Account account = Accounts.getAccount();

        accountConsumer.accept(account);
    }

    private static void calculate3xValueUsingIntegerFunction() {
        Function<Integer, Integer> tripleFunction = n -> 3 * n;
        int a = 12;

        System.out.println("3 * " + a + tripleFunction.apply(a));
    }

    private static void checkIfNumberIsPositiveUsingIntegerPredicate() {
        Predicate<Integer> isPositive = n -> n > 0;
        int b = 23;

        System.out.println(b + " is " + (isPositive.test(b) ? "positive" : "negative"));
    }

    private static void verifyGoogleEmailUsingAccountPredicate() {
        Account account = Accounts.getAccount();
        Predicate<Account> isGmailUser = a -> a.getEmail().endsWith("@gmail.com");

        System.out.println("\"" + account.getEmail() + "\"" + " is "
                + (isGmailUser.test(account) ? "" : "not") + " a Google mail.");
    }

    private static void printPrimeNumbersUsingIntegerPredicate() {
        Predicate<Integer> isPrime = n -> IntStream.range(2, n).noneMatch(i -> n % i == 0);

        IntStream.range(1, 10)
                .forEach(i -> System.out.printf("%3d %10s\n", i, (isPrime.test(i) ? " is prime" : "")));
    }
}
