package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamVsCollectionsExample {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Mike");
        names.add("Syed");
        names.add("Rajeev");
        System.out.println("---------------------");
        System.out.println(names);

        names.remove("Syed");
        System.out.println("---------------------");
        System.out.println(names);

        Stream<String> nameStream = names.stream();
        System.out.println("---------------------");
        nameStream.forEach(System.out::println);
        List<String> list = names.stream().filter(s->s.startsWith("M")).collect(Collectors.toList());
        System.out.println(list);
    }
}
