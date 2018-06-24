package com.bobocode;


import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

public class OptionalExamples {
    private static Account DEFAULT_ACCOUNT = Accounts.getAccount();

    public static void main(String[] args) {
        List<Account> accounts = Accounts.getAccountList(10);
        Optional<Account> optionalAccountWithMaxBalance = findAccountWithMaxBalance(accounts);

        printAccountUsingWrongApproach(optionalAccountWithMaxBalance);
        printAccountUsingRightApproach(optionalAccountWithMaxBalance);

        printAccountOrDefault(optionalAccountWithMaxBalance);
        printAccountOrRandomLazily(optionalAccountWithMaxBalance);
    }

    private static Optional<Account> findAccountWithMaxBalance(List<Account> accounts) {
        return accounts.stream().max(comparing(Account::getBalance));
    }

    /**
     * It is not correct to process to process {@link Optional} values in the old imperative way, as it is shown below
     */
    private static void printAccountUsingWrongApproach(Optional<Account> optionalAccountWithMaxBalance) {
        if (optionalAccountWithMaxBalance.isPresent()) {
            Account account = optionalAccountWithMaxBalance.get();
            System.out.println(account);
        }
    }

    /**
     * The right way is to pass a consumer that will be used in case {@link Optional} value is not empty
     */
    private static void printAccountUsingRightApproach(Optional<Account> optionalAccountWithMaxBalance) {
        optionalAccountWithMaxBalance.ifPresent(System.out::println);
    }

    /**
     * or add a default value. Now you're safely trying to get an account instance, because in case it's null
     * you'll get a default value
     */
    private static void printAccountOrDefault(Optional<Account> optionalAccount) {
        Account account = optionalAccount.orElse(DEFAULT_ACCOUNT);
        System.out.println(account);
    }

    /**
     * The version with {@link java.util.function.Supplier} should be used in case getting default value requires
     * additional resources. In this case default instance will be only created if optional account is empty
     */
    private static void printAccountOrRandomLazily(Optional<Account> optionalAccount) {
        Account account = optionalAccount.orElseGet(() -> Accounts.getAccount());
        System.out.println(account);
    }
}
