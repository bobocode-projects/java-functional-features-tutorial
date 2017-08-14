package com.bobocode;


import com.bobocode.model.Account;
import com.bobocode.model.CreditAccount;
import com.bobocode.util.TestDataProvider;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;

/**
 *
 */
public class OptionalExample_Mapping {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();
        Account defaultAccount = accounts.get(0);
        List<CreditAccount> creditAccounts = Collections.singletonList(new CreditAccount(BigDecimal.valueOf(1000)));

        Optional<Account> optionalAccount = accounts.stream().findAny();
        Account account = optionalAccount.get();

        // When you have hierarchical relation with potential null value, like an account that can be null, has a balance
        // field that also can be null
        if (account != null) {
            // some logic
            if (account.getBalance() != null) {
                System.out.println(account.getBalance());
            }
        }
        // When you want to access a nullable value of account, you can use method map(), that receives a mapper which
        // transform your nullable value into an optional value
        optionalAccount.map(Account::getBalance).ifPresent(System.out::println);

        // An example, when you process a stream and find an optional element, with and optional relation
        accounts.stream()
                .filter(a -> a.getEmail().endsWith("google.com"))
                .filter(a -> a.getBalance().compareTo(BigDecimal.valueOf(90000)) > 0)
                .findFirst()
                .map(Account::getBalance)
                .ifPresent(System.out::println);


        // Sometimes you can encounter a problem that when you use map() it wraps a value within Optional container,
        // and if that value is an optional, you get Optional<Optional<T>>. To avoid this use flatMap()
        creditAccounts.stream()
                .filter(a -> a.getEmail().endsWith("google.com"))
                .filter(a -> a.getBalance().compareTo(BigDecimal.valueOf(90000)) > 0)
                .findFirst()
                .flatMap(CreditAccount::getCreditBalance)
                .ifPresent(System.out::println);

    }
}
