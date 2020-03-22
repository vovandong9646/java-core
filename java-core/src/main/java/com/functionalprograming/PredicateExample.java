package com.functionalprograming;

import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {

        // if number > 10 return true or false
        Predicate<Integer> p1 = x -> x > 10;
        System.out.println(p1.test(1));

        // i > 10 && number is even number
        //Predicate<Integer> p2 = i -> i > 10 && i % 2 == 0;
        //System.out.println(p2.test(12));
        Predicate<Integer> p2 = i -> i % 2 == 0;
        System.out.println(p2.and(p1).test(20));


    }
}
