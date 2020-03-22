package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingByMinMaxAvarageExample {
    public static void main(String[] args) {

        // nhóm instructor có dạy online hay không rồi get ra số năm kinh nghiệm lớn nhất của từng cái đã nhóm
        // b1. groupingby isOnlineCourse = true/ false
        // b2. maxby -> experience

        Map<Boolean, Optional<Instructor>> r1 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::isOnlineCourses,
                        Collectors.maxBy(Comparator.comparing(Instructor::getYearsOfExperience))));
        r1.forEach((k,v) -> {
            System.out.println("key: " + k + " - value: " + v);
        });

        //key: false - value: Optional[Instructor{name='Tom', yearsOfExperience=10, title='FrontEnd Developers', gender='F', onlineCourses=false, courses=[Java Programing, Angular, ReactJs, Vuejs]}]
        //key: true - value: Optional[Instructor{name='Mike', yearsOfExperience=10, title='Software Developers', gender='M', onlineCourses=true, courses=[Java Programing, C++, Python]}]

        // collectingAndThen
        Map<Boolean, Instructor> maxInstructor1 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::isOnlineCourses,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Instructor::getYearsOfExperience))
                                , Optional::get)));
        maxInstructor1.forEach((k,v) -> {
            System.out.println("key: " + k + " - value: " + v);
        });

        // average year of experience of instructors who teaches online or not
        Map<Boolean, Double> maxInstructor2 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::isOnlineCourses,
                        Collectors.averagingInt(Instructor::getYearsOfExperience)));
        maxInstructor2.forEach((k,v) -> {
            System.out.println("key: " + k + " - value: " + v);
        });

        // summarizingInt()
        Map<Boolean, IntSummaryStatistics> maxInstructor3 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::isOnlineCourses,
                        Collectors.summarizingInt(Instructor::getYearsOfExperience)));
        maxInstructor3.forEach((k,v) -> {
            System.out.println("key: " + k + " - value: " + v);
        });

    }
}
