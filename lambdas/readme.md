# <img src="https://raw.githubusercontent.com/bobocode-projects/resources/master/image/logo_transparent_background.png" height=50/> Lambdas tutorial

This is the tutorial on lambdas, method reference, and functional interfaces. 
### Pre-conditions :heavy_exclamation_mark:
You're supposed to be familiar with OOP, have basic knowledge of JDK, and be able to write Java code. 
### Related exercises :muscle:
* [Math fucntions](https://github.com/bobocode-projects/java-8-exercises/tree/master/math-functions)
### See also :point_down:
* [Tutorial on Optional](https://github.com/bobocode-projects/java-8-tutorial/tree/master/optional)
* [Tutorial on Stream API](https://github.com/bobocode-projects/java-8-tutorial/tree/master/stream-api)
##
Java is an OOP language, so it always works with classes and **doesn't support standalone functions**. In case you want to **pass some function as a method parameter**, or **store some code into a variable**, you should use a *Functional Interface* and a *Lambda expression*. 

* A *Functional Interface* represents a **function signature**. It contains only one abstract method.
* A *Lambda expression* represents a **function body**. Is an anonymous function that implements the abstract method of the functional interface

The purpose of the lambda and functional interfaces is to **make it easier to create function objects** and provide an **ability to use some functional programming technics in Java.**

A typical example is interface `Comparator<T>`:

```java
        accounts.sort(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });
```
It can be easily simplified using lambda expression:
```java
        accounts.sort((a1, a2) -> a1.getFirstName().compareTo(a2.getFirstName()));
```
In case you are calling some existing method inside the lambda, you can reference that method instead of acctually calling it. This technique is called *Method Reference*. Combining it with usefull default method `comparing()` it can help you to simplify the code even more:
```java
        accounts.sort(comparing(Account::getFirstName));
```
