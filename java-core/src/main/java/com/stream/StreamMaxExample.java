package com.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamMaxExample {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,3,4,5,6,7,8,2);

        // max using stream max function
        int max = numbers.stream().max(Integer::compareTo).get();
        System.out.println(max);

        // max using reduce
        int maxUsingReduce = numbers.stream().reduce(0, (a,b) -> (a>b)?a:b);
        System.out.println(maxUsingReduce);

        int maxUsingReduce2 = numbers.stream().reduce(0, Integer::max);
        System.out.println(maxUsingReduce2);
    }
}
