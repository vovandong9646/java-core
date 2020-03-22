package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExample1 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Syed", "Mike", "Jenny", "Gene", "Rajeev");

//        Map<Integer, List<String>> result = names.stream().collect(Collectors.groupingBy(s -> s.length()));
        Map<Integer, List<String>> result = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(result);  //{4=[Syed, Mike, Gene], 5=[Jenny], 6=[Rajeev]}

        System.out.println("----------------------------------------------");

        // grouping by instructors by their gender
        Map<String, List<Instructor>> result2 = Instructors.getAll().stream().collect(Collectors.groupingBy(Instructor::getGender));
        System.out.println(result2);

        // grouping by instructors by their gender return name
        Map<String, List<String>> result3 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getGender, Collectors.mapping(Instructor::getName, Collectors.toList())));
        System.out.println(result3);

        // grouping by experience where > 5 years of experience is classified is senior else junior
        Map<String, List<Instructor>> result4 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(p -> {
                    if(p.getYearsOfExperience() > 5) {
                        return "SENIOR";
                    }else {
                        return "JUNIOR";
                    }
                }));
        System.out.println(result4);

    }
}
