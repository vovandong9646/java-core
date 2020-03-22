package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {

        // get name of courses
        List<String> courses = Instructors.getAll().stream()
                                                    .map(Instructor::getCourses)
                                                    .flatMap(List::stream)
                                                    .collect(Collectors.toList());
        System.out.println(courses);
    }
}
