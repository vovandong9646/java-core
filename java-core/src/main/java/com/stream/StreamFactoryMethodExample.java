package com.stream;

import java.util.Random;
import java.util.stream.Stream;

public class StreamFactoryMethodExample {

    public static void main(String[] args) {

        // of
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5);
        stream1.forEach(System.out::println);

        System.out.println("========================");

        // iterate()
        Stream<Integer> stream2 = Stream.iterate(0, i->i+2).limit(10);
        stream2.forEach(System.out::println);

        System.out.println("========================");

        // generate()
        Stream<Integer> stream3 = Stream.generate(new Random()::nextInt).limit(10);
        stream3.forEach(System.out::println);

    }

}
