package com.bobocode;

import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Method reference is a shorthand for lambda expression that could be use in some cases for better readability.
 */
public class MethodReference {
    public static void main(String[] args) {
        List<Account> accounts = Accounts.getAccountList(10);

        printAccountsWithLambda(accounts);
        printAccountsWithMethodReference(accounts);
    }

    private static void printAccountsWithLambda(List<Account> accounts) {
        consumeAccounts(accounts, a -> System.out.println(a));
    }

    private static void printAccountsWithMethodReference(List<Account> accounts) {
        consumeAccounts(accounts, System.out::println); //todo: think what if you want to print only emails
    }

    private static void consumeAccounts(List<Account> accounts, Consumer<Account> consumer) {
        for (Account account : accounts){
            consumer.accept(account);
        }
    }

}
