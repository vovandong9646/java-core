package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamReduceExample2 {
    public static void main(String[] args) {

        //printing the instructor who has the highest years of experience
        Optional instructor = Instructors.getAll().stream()
        //        Instructor instructor1 = new Instructor("Mike", 10, "Software Developers", "M",true, Arrays.asList("Java Programing", "C++", "Python"));
        //        Instructor instructor2 = new Instructor("Jenny", 5, "Engineer", "F",false, Arrays.asList("Multi-Thead", "CI/CD", "Unit Testing"));
        //        Instructor instructor3 = new Instructor("Tom", 10, "FrontEnd Developers", "F",false, Arrays.asList("Java Programing", "Angular", "ReactJs", "Vuejs"));
        //        Instructor instructor4 = new Instructor("Jerry", 10, "App Developers", "M",true, Arrays.asList("Android", "Swift", "React native"));

                // s1 : 10 > s2: 5 -> return 10   (lấy experience của s1 so sánh với s2 và sẽ trả về cái s1 là 10)
                // result: 10 > s3: 10 -> return s3: 10  (xong tiếp tục lấy kết quả 10 ở trên, đem đi so sánh với phần tử tiếp theo -> cho ra kết quả là s3 cũng là 10)
                // result: 10 > s4: 10 -> return s4: 10  (xong lấy kết quả ở trên so sánh với phần tử tiếp theo)

                .reduce((s1, s2) -> {
                    if(s1.getYearsOfExperience() > s2.getYearsOfExperience()) {
                        return s1;
                    } else {
                        return s2;
                    }
                });
        if(instructor.isPresent())
            System.out.println(instructor.get());


    }
}
