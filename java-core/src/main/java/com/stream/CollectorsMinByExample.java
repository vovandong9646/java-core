package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorsMinByExample {
    public static void main(String[] args) {

        // instructor with minimum year of experience
        Optional<Instructor> instructor = Instructors.getAll().stream()
                .collect(Collectors.minBy(Comparator.comparing(Instructor::getYearsOfExperience)));
        System.out.println(instructor);

        // stream.min
        Optional<Instructor> instructor1 = Instructors.getAll().stream().min(Comparator.comparing(Instructor::getYearsOfExperience));
        System.out.println(instructor1);
    }
}
