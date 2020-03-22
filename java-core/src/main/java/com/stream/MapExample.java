package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.List;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {


        // get name of instructors and uppercase name
        List<String> names = Instructors.getAll().stream()
                .map(Instructor::getName)
                .filter(n-> n.startsWith("J"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(names);
    }
}
