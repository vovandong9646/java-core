package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartitioningByExample {
    public static void main(String[] args) {
        // partition instructors in two group of instructor
        // first is year of experience is > 5 and other is <=5
        Predicate<Instructor> experiencePredicate = instructor -> instructor.getYearsOfExperience() > 5;
        Map<Boolean, List<Instructor>> partitionMap = Instructors.getAll().stream()
                .collect(Collectors.partitioningBy(experiencePredicate));
        partitionMap.forEach((k,v)->{
            System.out.println("key: "+k+" - value:"+v);
        });

//        key: false - value:[Instructor{name='Jenny', yearsOfExperience=5, title='Engineer', gender='F', onlineCourses=false, courses=[Multi-Thead, CI/CD, Unit Testing]}]
//        key: true - value:[Instructor{name='Mike', yearsOfExperience=10, title='Software Developers', gender='M', onlineCourses=true, courses=[Java Programing, C++, Python]}, Instructor{name='Tom', yearsOfExperience=10, title='FrontEnd Developers', gender='F', onlineCourses=false, courses=[Java Programing, Angular, ReactJs, Vuejs]}, Instructor{name='Jerry', yearsOfExperience=10, title='App Developers', gender='M', onlineCourses=true, courses=[Android, Swift, React native]}]

        // partition but return is set instead of list
        Predicate<Instructor> experiencePredicate1 = instructor -> instructor.getYearsOfExperience() > 5;
        Map<Boolean, Set<Instructor>> partitionMap1 = Instructors.getAll().stream()
                .collect(Collectors.partitioningBy(experiencePredicate1, Collectors.toSet()));
        partitionMap1.forEach((k,v)->{
            System.out.println("key: "+k+" - value:"+v);
        });
    }
}
