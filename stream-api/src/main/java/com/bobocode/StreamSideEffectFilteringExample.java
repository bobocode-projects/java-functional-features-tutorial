package com.bobocode;

import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.ArrayList;
import java.util.List;

public class StreamSideEffectFilteringExample {
    public static void main(String[] args) {
        List<Account> accounts = Accounts.getAccountList(10);

        List<Account> gmailAccounts = new ArrayList<>();

        accounts.stream()
                .filter(a -> a.getEmail().endsWith("@gmail.com"))
                .forEach(gmailAccounts::add);
    }
}
