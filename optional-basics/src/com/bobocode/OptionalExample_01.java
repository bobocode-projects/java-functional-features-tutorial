package com.bobocode;


import java.util.Optional;

public class OptionalExample_01 {
    public static void main(String[] args) {
        Optional<Integer> optionalFive = Optional.of(5);

        Integer someValue = optionalFive.orElse(10);

//        accounts.stream().peek(a -> System.out.println(a.getFirstName())).collect(summarizingDouble(a -> a.getBalance().doubleValue()));
//        Optional<Account> optionalAccount = accounts.stream().collect(maxBy(comparingDouble(a -> a.getBalance().doubleValue())));

        /*Optional<BigDecimal> balance = optionalAccount.map(Account::getBalance);


        String collect2 = accounts.stream().map(Account::getFirstName).collect(joining(", "));
        Map<Boolean, List<Account>> collect3 = accounts.stream().collect(partitioningBy(a -> a.getFirstName().length() > 4));

        DoubleConsumer consumer = System.out::println;
        double v = accounts.stream().mapToDouble(a -> a.getBalance().doubleValue()).reduce(Double::sum).orElseGet(() -> 25.0);

        UnaryOperator<String> toUpper = String::toUpperCase;
        UnaryOperator<String> doubler = s -> s + s;*/

    }
}
