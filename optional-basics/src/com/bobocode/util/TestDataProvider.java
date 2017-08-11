package com.bobocode.util;

import com.bobocode.model.Account;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestDataProvider {

    public static List<Account> generateAccountList() {
        List<Account> accounts = new ArrayList<>(6);
        accounts.add(new Account(1L, "Will", "Smith", "wsmith@gmail.com",
                LocalDate.of(1968, 8, 25), LocalDate.of(2012, 3, 19), BigDecimal.valueOf(104065.25)));
        accounts.add(new Account(2L, "Tom", "Hanks", "thanks@gmail.com",
                LocalDate.of(1956, 7, 9), LocalDate.of(2013, 2, 23), BigDecimal.valueOf(93065.25)));
        accounts.add(new Account(3L, "Russell", "Crowe", "rcrowe@gmail.com",
                LocalDate.of(1964, 4, 7), LocalDate.of(2014, 5, 17), BigDecimal.valueOf(87641.98)));
        accounts.add(new Account(4L, "Robert", "Downey", "rdowney@yahoo.com",
                LocalDate.of(1965, 4, 9), LocalDate.of(2015, 7, 24), BigDecimal.valueOf(152345)));
        accounts.add(new Account(5L, "Robert", "De Niro", "deniro@outlook.com",
                LocalDate.of(1943, 8, 17), LocalDate.of(2010, 8, 14), BigDecimal.valueOf(67065.45)));
        accounts.add(new Account(6L, "Metthew", "Perry", "mperry@gmail.com",
                LocalDate.of(1969, 8, 19), LocalDate.of(2011, 10, 4), BigDecimal.valueOf(45678.12)));
        return accounts;
    }

}