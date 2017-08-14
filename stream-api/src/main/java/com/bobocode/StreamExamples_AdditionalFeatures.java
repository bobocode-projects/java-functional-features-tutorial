package com.bobocode;


import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Set;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.toSet;

/**
 * Stream API provides a lot of useful features features that help you process data even more concise.
 */
public class StreamExamples_AdditionalFeatures {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();

        // Sorting elements
        System.out.println("Account owner's sorter names: ");
        accounts.stream()
                .sorted(comparing(Account::getFirstName))
                .forEach(a -> System.out.println(a.getFirstName()));

        // Stream API allow you to skip some elements, and limit the number of elements in the stream
        System.out.println("\nSort by first name, skip first two, and get only two:  ");
        accounts.stream()
                .sorted(comparing(Account::getFirstName))
                .skip(2)
                .limit(2)
                .forEach(a -> System.out.println(a.getFirstName()));

        // Collector that collects statistic based on double values of stream elements
        DoubleSummaryStatistics balanceStatistic = accounts.stream()
                .collect(summarizingDouble(a -> a.getBalance().doubleValue()));
        System.out.println("\nAccount balances statistic: " + balanceStatistic);

        // Since forEach() is a terminal operation, you can not continue working with stream
        // That's why Stream API provides another method, that has the similar capabilities but does not terminate a stream
        System.out.println("\nPrint stream elements in scope of intermediate operations peek(): ");
        accounts.stream()
                .peek(a -> System.out.println(a.getFirstName()))
                .map(Account::getEmail)
                .collect(toSet());
    }
}
