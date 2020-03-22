package com.stream;

import com.functionalprograming.Instructor;
import com.functionalprograming.Instructors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningExample {
    public static void main(String[] args) {

        // nếu sử dụng reduce
        String result = Stream.of("E","F","G","H").reduce("", String::concat);
        System.out.println(result);  // EFGH

        // nếu sử dụng join
        String result1 = Stream.of("E","F","G","H").collect(Collectors.joining());
        System.out.println(result1);  // EFGH

        // nếu sử dụng reduce
        String result2 = Stream.of("E","F","G","H").reduce("", (a,b)-> a.concat(",").concat(b));
        System.out.println(result2);  // ,E,F,G,H(dư cái dấu phẩy ở trước)

        // nếu dùng hàm joining()
        String result3 = Stream.of("E","F","G","H").collect(Collectors.joining(","));
        System.out.println(result3);  // E,F,G,H

        // nếu sử dụng reduce (không được)
        // nếu sử dụng foreach (không được)
        // nếu sử dụng map (không được)
        String result4 = Stream.of("E","F","G","H").collect(Collectors.joining("," , "{", "}"));
        System.out.println(result4);

        // instructor names seperated by ' and prefix { and suffix }
        String names = Instructors.getAll().stream()
                    .map(Instructor::getName).collect(Collectors.joining("','","{'","'}"));
        System.out.println(names);  // {'Mike','Jenny','Tom','Jerry'}

    }
}
