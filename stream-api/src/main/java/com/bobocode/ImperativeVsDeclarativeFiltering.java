package com.bobocode;

import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ImperativeVsDeclarativeFiltering {
    public static void main(String[] args) {
        List<Account> accounts = Accounts.getAccountList(10);

        findAllGmailAccountImperatively(accounts);
        findAllGmailAccountDeclaratively(accounts);

    }

    private static List<Account> findAllGmailAccountImperatively(List<Account> accounts) {
        List<Account> gmailAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getEmail().endsWith("@gmail.com")) {
                gmailAccounts.add(account);
            }
        }
        return gmailAccounts;
    }

    private static void findAllGmailAccountDeclaratively(List<Account> accounts) {
        accounts.stream()
                .filter(a -> a.getEmail().endsWith("@gmail"))
                .collect(toList());
    }

}
