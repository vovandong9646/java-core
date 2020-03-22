package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {
    public static void main(String[] args) {


        // returning instructors sorted by their name and have more that 5 year of experience
        List<Instructor> list = Instructors.getAll().stream()
                .sorted(Comparator.comparing(Instructor::getName))
                .filter(i -> i.getYearsOfExperience() > 5)
                .collect(Collectors.toList());

        list.forEach(System.out::println);


    }
}
