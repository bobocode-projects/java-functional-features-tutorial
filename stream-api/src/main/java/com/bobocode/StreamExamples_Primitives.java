package com.bobocode;


import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class StreamExamples_Primitives {
    public static void main(String[] args) {
        List<Account> accounts = Accounts.getAccountList(10);

        // You can create a stream of primitive value
        LongStream longStream = LongStream.range(1, 1000);
        // You can transform a stream of primitives into stream of objects (LongStream to Stream<Long>)
        Stream<Long> boxedLongStream = longStream.boxed();

        // When you work with values it's better to transform stream into primitives for performance reasons
        // You can transform accounts Stream<Account> into primitive stream DoubleStream, and then find max value
        double maxBalance = accounts.stream()
                .mapToDouble(a -> a.getBalance().doubleValue())
                .max().getAsDouble();

        // You can also find an account with max balance
        Account theRichestGuy = accounts.stream()
                .max(comparing(Account::getBalance)).get();
        System.out.println("The richest guy is " + theRichestGuy.getFirstName() + " " + theRichestGuy.getLastName());


    }
}
