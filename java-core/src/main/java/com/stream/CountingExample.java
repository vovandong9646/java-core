package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.stream.Collectors;

public class CountingExample {
    public static void main(String[] args) {

        // count numbers of instructors who teaches online courses
        // stream.count
        long result1 = Instructors.getAll().stream().filter(Instructor::isOnlineCourses).count();
        System.out.println(result1);

        // using Collectors.counting()
        long result2 = Instructors.getAll().stream().filter(Instructor::isOnlineCourses).collect(Collectors.counting());
        System.out.println(result2);
    }
}
