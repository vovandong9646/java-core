package com.functionalprograming;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample2 {

    public static void main(String[] args) {

        List<Instructor> instructors = Instructors.getAll();

        System.out.println("-----------------------------------------");
        // looping through all the instructor and printing all out the values of instructor
        Consumer<Instructor> c1 = (s1) -> System.out.println(s1);
        instructors.forEach(c1);

        System.out.println("-----------------------------------------");
        // Looping through all in the instructor and only print out their name
        Consumer<Instructor> c2 = (s1) -> System.out.println(s1.getName());
        instructors.forEach(c2);

        System.out.println("-----------------------------------------");
        // Loop through all the instructors and print out their names and their coursers
        Consumer<Instructor> c3 = (s1) -> System.out.println(s1.getCourses());
        instructors.forEach(c2.andThen(c3));

        System.out.println("-----------------------------------------");
        // Loop through all the instructors and print out their name if the years of experience is > 10
        instructors.forEach(s1 -> {
            if(s1.getYearsOfExperience() > 10) {
                c1.accept(s1);
            }
        });

        // Loop through all the instructors and print out their name and years of experience if years
        // of experiences is  > 5 and teaches course online
        instructors.forEach(s1 -> {
            if(s1.getYearsOfExperience() > 5 && s1.isOnlineCourses()) {
                c1.andThen(c2).accept(s1);
            }
        });
    }

}
