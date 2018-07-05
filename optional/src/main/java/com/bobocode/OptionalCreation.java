package com.bobocode;

import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.Optional;

public class OptionalCreation {
    public static void main(String[] args) {
        Account account = Accounts.getAccount();

        Optional<Account> optionalAccount = Optional.of(account);

        Optional<Account> optionalNullableAccount = Optional.ofNullable(account);

        Optional<Account> optionalEmptyAccount = Optional.empty();
    }
}
