package com.bobocode;


import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;

/**
 *
 */
public class OptionalExample_Basics {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();
        Account defaultAccount = accounts.get(0);

        Optional<Integer> optionalFive = Optional.of(5);
        Integer someValue = optionalFive.orElse(10);

        // When you want to calculate some value using reduce() operation on a stream, and don't provide an initial
        // value, you are not sure whether the result is determined. Therefore you get an optional result
        OptionalDouble optionalSum = accounts.stream()
                .mapToDouble(a -> a.getBalance().doubleValue())
                .reduce(Double::sum);

        // You can try to find an account with max value of balance, and the result will be optional
        Optional<Account> optionalAccountWithMaxBalance = accounts.stream().collect(maxBy(comparing(Account::getBalance)));
        // A simplified form of this operation is available
        optionalAccountWithMaxBalance = accounts.stream().max(comparing(Account::getBalance));

        // To get a value
        optionalAccountWithMaxBalance.get();
        // but it's not recommended, because it also can throw an exception. The right way is to provide a consumer,
        optionalAccountWithMaxBalance.ifPresent(a -> System.out.println("Account with max balance: " + a.getEmail()));
        // or add a default value. Now you're safely trying to get an account instance, because in case it's null
        // you'll get a default value
        Account account = optionalAccountWithMaxBalance.orElse(defaultAccount);
        // this version with Supplier is also available for the performance reasons
        account = optionalAccountWithMaxBalance.orElseGet(() -> defaultAccount);

    }
}
