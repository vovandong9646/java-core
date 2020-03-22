package com.functionalprograming;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {

        List<Instructor> instructors = Instructors.getAll();

        // in ra ten, title cua nhung teacher co tren 5 nam kinh nhiem
        BiConsumer<String, String> teacher = (name, title) -> {
            System.out.println("name: " + name + " - title: " + title);
        };

        instructors.forEach(instructor -> {
            if(instructor.getYearsOfExperience() > 5) {
                teacher.accept(instructor.getName(), instructor.getTitle());
            }
        });




    }

}
