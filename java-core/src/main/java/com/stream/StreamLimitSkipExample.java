package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.List;

public class StreamLimitSkipExample {
    public static void main(String[] args) {

        // list initial
        System.out.println("list initial");
        Instructors.getAll().forEach(System.out::println);
        System.out.println("------------------------------");

        System.out.println("list skip and limit");
        Instructors.getAll().stream().skip(1).limit(2).forEach(System.out::println);

    }

}
