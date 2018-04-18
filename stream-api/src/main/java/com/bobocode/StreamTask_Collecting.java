package com.bobocode;


import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.List;

/**
 * Using Stream API, lambda, and predefined functional interfaces implement the code according to requirements
 */
public class StreamTask_Collecting {
    public static void main(String[] args) {
        List<Account> accounts = Accounts.getAccountList(10);

        // 1 - Find a set of account owner's names(first name) that have a length <= 4

        // 2 - Group all accounts by its email providers. (You can consider as an email provider
        // everything that goes after @ sign

        // 3 - Find the richest guy

        // 4 - Find the richest guy for each email provider

        // 5 - Split accounts by their balance (those who have more than $90 000.00, and those who don't)

    }
}
