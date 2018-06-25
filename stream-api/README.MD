# <img src="https://raw.githubusercontent.com/bobocode-projects/resources/master/image/logo_transparent_background.png" height=50/> Stream API tutorial

This is the tutorial on Stream API and functional programming techniques
### Pre-conditions :heavy_exclamation_mark:
You're supposed to be familiar with OOP, have basic knowledge of JDK, and be able to write Java code. 
### Related exercises :muscle:
*
### See also :point_down:
* [Tutorial on Lambdas](https://github.com/bobocode-projects/java-functional-features-tutorial/tree/master/lambdas)
* [Tutorial on Optional](https://github.com/bobocode-projects/java-functional-features-tutorial/tree/master/optional)
##
*Stream API* provide an ability to **process sequences of data elements in a declarative way** and **simplify the task of 
performing operations in parallel**

The simplest example is the task of filtering a collection. Using **imperative** old-style approach we specify **HOW the task 
should be done**. E.g. dealing with iteration, and storing each element in a new `ArrayList`. This way of processing is also 
called *external iteration*. *Stream API* and it's **declarative** approach allows us to specify **WHAT should be done**, without 
actually dealing with iteration and elements. This approach is also called *internal iteration*. 

Imperative style:
```java
        List<Account> gmailAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getEmail().endsWith("@gmail.com")) {
                gmailAccounts.add(account);
            }
        }
```
Declarative style using *Stream API*:
```java
        List<Account> gmailAccounts = accounts.stream()
                .filter(a -> a.getEmail().endsWith("@gmail"))
                .collect(toList());
```
