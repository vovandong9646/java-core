package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.stream.Collectors;

public class CollectorsSummingAveragingExample {
    public static void main(String[] args) {

        // sum of years of experience of all instructors
        int sum = Instructors.getAll().stream()
                .collect(Collectors.summingInt(Instructor::getYearsOfExperience));
        System.out.println(sum);

        // calculate average of year of experience of all instructors
        double average = Instructors.getAll().stream()
                .collect(Collectors.averagingInt(Instructor::getYearsOfExperience));
        System.out.println(average);
    }
}
