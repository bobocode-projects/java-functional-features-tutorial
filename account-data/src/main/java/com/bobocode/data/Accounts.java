package com.bobocode.data;

import com.bobocode.model.Account;
import com.bobocode.model.CreditAccount;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import static java.math.BigDecimal.valueOf;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public interface Accounts {
    static Account getAccount() {
        Account fakeAccount = new Account();
        initializeFakeFields(fakeAccount);

        return fakeAccount;
    }

    static List<Account> getAccountList(int size) {
        return range(0, size)
                .mapToObj(i -> getAccount())
                .collect(toList());
    }

    static CreditAccount getCreditAccount() {
        Random random = new Random();
        CreditAccount creditAccount = new CreditAccount();
        initializeFakeFields(creditAccount);
        creditAccount.setCreditBalance(valueOf(random.nextInt(100_000)));

        return creditAccount;
    }

    static List<CreditAccount> getCreditAccountsList(int size) {
        return range(0, size)
                .mapToObj(i -> getCreditAccount())
                .collect(toList());
    }


    private static void initializeFakeFields(Account account) {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        Random random = new Random();

        account.setFirstName(person.getFirstName());
        account.setLastName(person.getLastName());
        account.setEmail(person.getEmail());
        account.setBirthday(LocalDate.of(
                person.getDateOfBirth().getYear(),
                person.getDateOfBirth().getMonthOfYear(),
                person.getDateOfBirth().getDayOfMonth()));
        account.setBalance(valueOf(random.nextInt(200_000)));
        account.setCreationDate(LocalDateTime.now());
    }
}
