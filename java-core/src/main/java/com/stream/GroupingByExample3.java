package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExample3 {
    public static void main(String[] args) {

        // instructor grouping them by senior (>5) and juhior (<=5) and filter them on online courses
        LinkedHashMap<String, List<String>> result1 = Instructors.getAll().stream().filter(Instructor::isOnlineCourses)
                .collect(Collectors.groupingBy(p->{
                    if(p.getYearsOfExperience() > 5) {
                        return "SENIOR";
                    } else {
                        return "JUNIOR";
                    }
                }, LinkedHashMap::new, Collectors.mapping(Instructor::getName, Collectors.toList())));
        System.out.println(result1); // ở đây dùng Collectors.filtering() thì sẽ đúng hơn, nhưng java 8 nó không hổ trợ hàm này

    }
}
