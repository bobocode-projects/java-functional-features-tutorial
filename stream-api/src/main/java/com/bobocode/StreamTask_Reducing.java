package com.bobocode;


import com.bobocode.model.Account;
import com.bobocode.util.TestDataProvider;

import java.util.List;

/**
 * Using Stream API, lambdas, and predefined functional interfaces implement the code according to requirements
 */
public class StreamTask_Reducing {
    public static void main(String[] args) {
        List<Account> accounts = TestDataProvider.generateAccountList();

        // 1 - Calculate sum of all account balances using reduce() method that receives two parameters:
        // default value and lambda (DO NOT USE METHOD REFERENCE)

        // 2 - Compute the amount of all stream elements using reduce methods that receives two parameters
        // default value and lambda (DO NOT USE METHOD REFERENCE)

        // 3 - Concatenate all last names into a single string, separated by commas, using reduce() method

    }
}
