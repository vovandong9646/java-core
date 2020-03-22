package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.List;
import java.util.stream.Collectors;

public class StreamOperatorExample {
    public static void main(String[] args) {


        List<String> instructorCourses = Instructors.getAll().stream().map(Instructor::getCourses)
                                                        .flatMap(List::stream)
                                                        .collect(Collectors.toList());
        // count
        long count = Instructors.getAll().stream().map(Instructor::getCourses)
                .flatMap(List::stream).count();
        System.out.println("count: " + count);

        // distinct  // chỉ có 1 java programing
        List<String> names = Instructors.getAll().stream().map(Instructor::getCourses)
                .flatMap(List::stream).distinct().collect(Collectors.toList());
        System.out.println(names);

        // anymatch, allmatch, nonmatch   names = ['Mike','Jenny','Tom','Jerry']
        boolean match = Instructors.getAll().stream().map(Instructor::getName)
                .noneMatch(s -> s.startsWith("J"));
        System.out.println(match);

    }
}
