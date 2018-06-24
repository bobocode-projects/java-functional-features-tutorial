package com.bobocode;

import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class OptionalReturningMethodExample {
    public static void main(String[] args) {
        List<Account> accounts = Accounts.getAccountList(20);
        Optional<Account> luckyGuy = findLuckyGuy(accounts);
        printResult(luckyGuy);

    }

    /**
     * If in some cases a method cannot produce a retuning value, use an {@link Optional}
     * as a returning-value in favor of null
     */
    private static Optional<Account> findLuckyGuy(List<Account> accounts) {
        Random random = new Random();
        int luckyIndex = random.nextInt(accounts.size() * 3);
        if (luckyIndex < accounts.size()) {
            return Optional.of(accounts.get(luckyIndex));
        } else {
            // return null; // TODO: NEVER EVER RETURN null FROM AN OPTIONAL-RETURNING METHOD
            return Optional.empty();
        }
    }

    /**
     * Instead of using imperative if-else statement, use ifPresentOrElse() method
     */
    private static void printResult(Optional<Account> optionalAccount) {
        optionalAccount.ifPresentOrElse(System.out::println, () -> System.out.println("No luck! Try again..."));
    }
}
