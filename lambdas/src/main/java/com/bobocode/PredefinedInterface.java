package com.bobocode;

import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Predefined interface is a standard @{@link FunctionalInterface} that represent some well-known function type.
 * E.g. @{@link java.util.function.Predicate}, @{@link java.util.function.Function}, @{@link java.util.function.Consumer}
 *
 * The same example with custom functional interfaces was shown in {@link BehaviorParameterizationWithLambda}
 */
public class PredefinedInterface {
    public static void main(String[] args) {
        List<Account> accounts = Accounts.getAccountList(10);

        processAccounts(accounts,
                a -> Period.between(a.getCreationDate().toLocalDate(), LocalDate.now()).getYears() > 4,
                a -> a.setBalance(a.getBalance().add(BigDecimal.valueOf(50))));
    }

    /**
     * Customer functional interfaces @{@link com.bobocode.functions.Operation}, and @{@link com.bobocode.functions.Condition}
     * were removed in favor of standard ones @{@link Consumer}, and @{@link Predicate} accordingly
     */
    private static void processAccounts(List<Account> accounts, Predicate<Account> accountPredicate,
                                        Consumer<Account> accountConsumer) {
        for (Account account : accounts) {
            if (accountPredicate.test(account)) {
                accountConsumer.accept(account);
            }
        }
    }

}
