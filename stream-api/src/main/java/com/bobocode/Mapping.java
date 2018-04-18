package com.bobocode;


import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Mapping {
    public static void main(String[] args) {
        List<Account> accounts = Accounts.getAccountList(10);

        // Mapping elements, method map() receives a Function<Account, String>. This function transforms(map) each
        // element of the stream into another value (transforms each account object into its email). Method map()
        // produce a new stream Stream<String> (stream of emails)
        System.out.println("\nTransform accounts stream into emails stream, and print each element:");
        accounts.stream()
                .map(account -> account.getEmail())
                .forEach(email -> System.out.println(email));

        // You can simplify the following lambda account -> account.getEmail() with method reference Account::getEmail
        // You can also simplify email -> System.out.println(email) with another method reference System.out::println
        System.out.println("\nThe same operation using method references:");
        accounts.stream()
                .map(Account::getEmail)
                .forEach(System.out::println);


        // Count number of occurrences for each letter in each account first and last names
        // flatMap() is used to transform Stream<Stream<T>> into Stream<T>
        // Not you see the problem, that Java 8 doesn't provide a primitive stream API for characters
        Map<Character, Long> lettersCount = accounts.stream()
                .flatMapToInt(a -> Stream.of(a.getFirstName(), a.getLastName())
                        .map(String::toUpperCase)
                        .flatMapToInt(CharSequence::chars))
                .mapToObj(a -> (char) a)
                .filter(s -> s != ' ')
                .collect(groupingBy(identity(), counting()));

        System.out.println(lettersCount);

        Supplier<Double> randomSupplier = Math::random;
        Stream.generate(randomSupplier).limit(100).forEach(System.out::println);

    }
}
