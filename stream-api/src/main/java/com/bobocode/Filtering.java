package com.bobocode;


import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Filtering {
    public static void main(String[] args) {
        List<Account> accounts = Accounts.getAccountList(10);

        // Filtering elements, method filter receives Predicate<String> and returns true if an email is gmail based.
        // Please note, that we transform the stream of accounts into stream of emails before filtering
        System.out.println("\nTransform account stream into emails, filter all emails that are not gmail: ");
        Predicate<String> isGoogleBased = email -> email.endsWith("gmail.com");
        Stream<String> stringStream = accounts.stream()
                .map(Account::getEmail)
                .filter(isGoogleBased);


        // You can also filter a stream of account without transformation
        System.out.println("\nThe same operation without transforming stream into emails: ");
        accounts.stream()
                .filter(a -> a.getEmail()
                        .endsWith("gmail.com"))
                .forEach(a -> System.out.println(a.getFirstName()));
    }
}
