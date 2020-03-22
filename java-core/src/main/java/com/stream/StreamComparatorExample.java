package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamComparatorExample {
    public static void main(String[] args) {

        // returning all instructors sorted by their name
        List<String> names = Instructors.getAll()
                                        .stream()
                                        .map(Instructor::getName)
                                        .sorted()
                                        .collect(Collectors.toList());

        List<Instructor> listInstructor = Instructors.getAll()
                                                        .stream()
                                                        .sorted(Comparator.comparing(Instructor::getName).reversed())
                                                        .collect(Collectors.toList());
        listInstructor.forEach(System.out::println);
    }
}
