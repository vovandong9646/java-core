package com.functionalprograming;

import java.util.Arrays;
import java.util.List;

public class Instructors {

    public static List<Instructor> getAll() {
        Instructor instructor1 = new Instructor("Mike", 10, "Software Developers", "M",true, Arrays.asList("Java Programing", "C++", "Python"));
        Instructor instructor2 = new Instructor("Jenny", 5, "Engineer", "F",false, Arrays.asList("Multi-Thead", "CI/CD", "Unit Testing"));
        Instructor instructor3 = new Instructor("Tom", 10, "FrontEnd Developers", "F",false, Arrays.asList("Java Programing", "Angular", "ReactJs", "Vuejs"));
        Instructor instructor4 = new Instructor("Jerry", 10, "App Developers", "M",true, Arrays.asList("Android", "Swift", "React native"));
        return Arrays.asList(instructor1, instructor2, instructor3, instructor4);
    }

}
