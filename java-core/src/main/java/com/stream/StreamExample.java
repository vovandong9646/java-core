package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {

        List<Instructor> instructors = Instructors.getAll();
        Predicate<Instructor> isOnline = (a) -> a.isOnlineCourses() == true;
        Set<Instructor> map = instructors
                .stream()
                .filter(instructor -> isOnline.test(instructor))
                .collect(Collectors.toSet());
        System.out.println(map);
    }

}
