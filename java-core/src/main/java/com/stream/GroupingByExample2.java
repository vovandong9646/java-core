package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExample2 {
    public static void main(String[] args) {
        // nhóm string theo length và check names có tồn tại e không, nếu có thì in ra
        List<String> names = Arrays.asList("Sid", "Mike", "Jenny", "Gene", "Rajeev");
//        Map<Integer, List<String>> result = names.stream()
//                .collect(Collectors.groupingBy(String::length, Collectors.filtering(s -> s.contains("e"), Collectors.toList())));
//        System.out.println(result);  // cái hàm filtering này sử dụng trong java 9 - nó cũng giống như hàm stream.filter()

        Map<Integer, List<String>> result = names.stream().filter(s -> s.contains("e"))
                .collect(Collectors.groupingBy(String::length));
        System.out.println(result); // {4=[Mike, Gene], 5=[Jenny], 6=[Rajeev]} - nó không in ra được 3=[]

        // instructor grouping them by senior (>5) and juhior (<=5) and filter them on online courses
        Map<String, List<Instructor>> result1 = Instructors.getAll().stream().filter(Instructor::isOnlineCourses)
                .collect(Collectors.groupingBy(p->{
                    if(p.getYearsOfExperience() > 5) {
                        return "SENIOR";
                    } else {
                        return "JUNIOR";
                    }
                }));
        System.out.println(result1); // ở đây dùng Collectors.filtering() thì sẽ đúng hơn, nhưng java 8 nó không hổ trợ hàm này

    }
}
