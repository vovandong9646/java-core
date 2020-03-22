package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

public class StreamMapFilterReduceExample {
    // map  -> là in ra những properties có trong mảng mà ta muốn lấy ra (ví dụ ta muốn lấy ra cái name của object instructor trong mảng instructors)
    // filter -> lọc mảng theo điều kiện mong muốn
    // reduce  -> so sánh, tính toán,.. đối với các phần tử trong mảng

    public static void main(String[] args) {

        // total years of experience b/w instructors
        int totalYearExperience = Instructors.getAll().stream()
                .filter(i -> i.isOnlineCourses() == true)
                .map(Instructor::getYearsOfExperience)
                .reduce((i1, i2) -> i1 + i2).get();


        int totalYearExperience2 = Instructors.getAll().stream()
                .filter(Instructor::isOnlineCourses)
                .map(Instructor::getYearsOfExperience)
                .reduce(Integer::sum).get();
        System.out.println(totalYearExperience2);
    }

}
