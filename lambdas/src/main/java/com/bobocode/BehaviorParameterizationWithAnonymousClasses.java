package com.bobocode;

import com.bobocode.data.Accounts;
import com.bobocode.functions.Condition;
import com.bobocode.functions.Operation;
import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static java.time.Period.between;

/**
 * Behavior parameterization with Interfaces and anonymous classes.
 *
 * We can pass conditional object and operation that should be applied on account when
 * the condition is true.
 *
 * The problem is solved. Right?
 *
 * Do you like the code? Is it easy to understand what is does? Imagine that you will decide to
 * add another operation that will be applied when the condition is false.
 *
 * Nice behavior parameterization requires us to pass functions as method arguments.
 * See @{@link BehaviorParameterizationWithLambda}
 */
public class BehaviorParameterizationWithAnonymousClasses {

    public static void main(String[] args) {
        List<Account> accounts = Accounts.getAccountList(10);

        Condition<Account> loyalClientCondition = new Condition<Account>() {
            @Override
            public boolean isTrue(Account account) {
                return between(account.getCreationDate().toLocalDate(), LocalDate.now()).getYears() > 4;
            }
        };
        Operation<Account> bonusOperation = new Operation<Account>() {
            @Override
            public void apply(Account account) {
                BigDecimal bonus = BigDecimal.valueOf(50);
                account.setBalance(account.getBalance().add(bonus));
            }
        };

        processAccounts(accounts, loyalClientCondition, bonusOperation);
    }

    private static void processAccounts(List<Account> accounts, Condition<Account> condition,
                                                     Operation<Account> operation) {
        for (Account account : accounts){
            if (condition.isTrue(account)){
                operation.apply(account);
            }
        }
    }
}

