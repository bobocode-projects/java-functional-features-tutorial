package com.bobocode;


import com.bobocode.data.Accounts;
import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.math.BigDecimal;
import java.util.List;

/**
 * Stream reducing is performed with method reduce(), that repeatedly process stream elements to provide a single value
 */
public class StreamExamples_Reducing {
    public static void main(String[] args) {
        List<Account> accounts = Accounts.getAccountList(10);

        // The Stream<Account> is transformed to DoubleStream (a stream of account balances)
        // Then this stream is reduced to the sum of all account
        double totalAmount = accounts.stream()
                .mapToDouble(a -> a.getBalance().doubleValue())
                .reduce(1, (a, b) -> a * b);
        // Another example of reduce() method usage is finding max value
        double maxBalanceValue = accounts.stream()
                .mapToDouble(a -> a.getBalance().doubleValue())
                .reduce(Double::max)
                .getAsDouble();

    }
}
