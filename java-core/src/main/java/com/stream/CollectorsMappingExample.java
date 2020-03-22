package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsMappingExample {
    public static void main(String[] args) {

        // stream.map()
        List<String> names = Instructors.getAll()
                .stream()
                .map(Instructor::getName)
                .collect(Collectors.toList());
        System.out.println(names);

        // Collectors.mapping()
        List<String> names1 = Instructors.getAll()
                .stream()
                .collect(Collectors.mapping(Instructor::getName, Collectors.toList()));
        System.out.println(names1);

        // instructors by their year of experience (in ra tên và số năm kinh nghiệm)
        // nếu dùng map bình thường thì chỉ in được ra tên or số năm kinh nghiệm (chỉ 1 trong 2 cái)
        Map<Integer, String> map1 = Instructors.getAll().stream()
                .collect(Collectors.toMap(Instructor::getYearsOfExperience, Instructor::getName, (i1, i2) -> i1));
        map1.forEach((key, value) -> {
            System.out.println("key: " + key + " , value: " + value);
        });
        //key: 5 , value: Jenny
        //key: 10 , value: Mike

        // giờ muốn in ra
        // key: 5 , value: Jenny
        // key: 10 , value: Mike, Jerry, Tom
        System.out.println("------------------------------");
        Map<Integer, List<String>> map2 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getYearsOfExperience , Collectors.mapping(Instructor::getName, Collectors.toList())));
        map2.forEach((key, value) -> {
            System.out.println("key: " + key + " , value: " + value);
        });
    }
}
