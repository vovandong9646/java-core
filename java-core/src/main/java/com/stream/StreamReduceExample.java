package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        // sum all -> 1 + 1 = 2+ 2 =4+3=7+4=11+5=16+6=22+7=29+8=37+9=46
        int result1 = numbers.stream().reduce(1, (a, b) -> a + b);
        int result2 = numbers.stream().reduce(0, (a, b)-> a * b);
        System.out.println(result1);
        System.out.println(result2);

        // nếu không truyền giá trị ban đầu thì nó sẽ lấy giá trị đầu tiên để tính toán
        Optional<Integer> result3 = numbers.stream().reduce((a, b) -> a * b);
        System.out.println("-----------------------------");
        if(result3.isPresent()) {
            System.out.println(result3.get());
        }

    }
}
