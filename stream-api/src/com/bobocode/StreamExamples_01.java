package com.bobocode;


import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.*;

public class StreamExamples_01 {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();
//        List<Account> accounts = Collections.emptyList();


        DoubleSummaryStatistics collect = accounts.stream().collect(summarizingDouble(a -> a.getBalance().doubleValue()));
         accounts.stream().peek(a -> System.out.println(a.getFirstName())).collect(summarizingDouble(a -> a.getBalance().doubleValue()));
        Optional<Account> optionalAccount = accounts.stream().collect(maxBy(comparingDouble(a -> a.getBalance().doubleValue())));

        Optional<BigDecimal> balance = optionalAccount.map(Account::getBalance);


        String collect2 = accounts.stream().map(Account::getFirstName).collect(joining(", "));
        Map<Boolean, List<Account>> collect3 = accounts.stream().collect(partitioningBy(a -> a.getFirstName().length() > 4));

        DoubleConsumer consumer = System.out::println;
        double v = accounts.stream().mapToDouble(a -> a.getBalance().doubleValue()).reduce(Double::sum).orElseGet(() -> 25.0);

        UnaryOperator<String> toUpper = String::toUpperCase;
        UnaryOperator<String> doubler = s -> s + s;



        Function<String, String> compose = toUpper.compose(doubler);

        System.out.println(compose.apply("Hello"));


        System.out.println(v);
    }
}
