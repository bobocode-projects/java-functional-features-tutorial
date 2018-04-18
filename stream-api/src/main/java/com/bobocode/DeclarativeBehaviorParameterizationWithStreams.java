package com.bobocode;

import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class DeclarativeBehaviorParameterizationWithStreams {
    public static void main(String[] args) {
        List<Account> accounts = Accounts.getAccountList(10);
        Predicate<Account> hasBeenClientForMoreThanFourYears
                = a -> Period.between(a.getCreationDate().toLocalDate(), LocalDate.now()).getYears() > 4;
        Consumer<Account> addBonus = a -> a.setBalance(a.getBalance().add(BigDecimal.valueOf(50)));

        accounts.stream()
                .filter(hasBeenClientForMoreThanFourYears)
                .forEach(addBonus);
    }
}
