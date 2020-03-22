package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.Optional;

public class StreamFindAnyAndFirstExample {
    public static void main(String[] args) {

        // lấy 1 phần tử bất kì trong mảng
        Optional<Instructor> instructor = Instructors.getAll().stream().findAny();
        if(instructor.isPresent())
            System.out.println(instructor.get());

        // lấy phần tử đầu tiên trong mảng
        Optional<Instructor> instructor1 = Instructors.getAll().stream().findFirst();
        System.out.println(instructor1.get());

    }
}
