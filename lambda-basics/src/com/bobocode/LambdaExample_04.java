package com.bobocode;

import com.bobocode.functions.Operation;
import com.bobocode.model.Account;

import java.time.LocalDateTime;

public class LambdaExample_04 {
    public static void main(String[] args) {
        Operation<Account> sendEmailOperation = a -> System.out.println(a.getEmail());

        Operation<Account> sayGreeting = (LocalDateTime.now().getHour() < 12) ?
                (a -> System.out.println("Good morning, " + a.getFirstName()))
                : (a -> System.out.println("Hello, " + a.getFirstName()));


    }
}
