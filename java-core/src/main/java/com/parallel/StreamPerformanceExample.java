package com.parallel;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class StreamPerformanceExample {
    public static void main(String[] args) {
        int loop = 20;
        long result = measurePerformace(StreamPerformanceExample::sumSequentialStream, loop);
        System.out.println("Time in sequential: " + result + " in msecs");
        result = measurePerformace(StreamPerformanceExample::sumParallelStream, loop);
        System.out.println("Time in parallel: " + result + " in msecs");
    }

    public static long measurePerformace(Supplier<Integer> supplier, int numberOfTimes) {
        long startTime = System.currentTimeMillis();
        for(int i=0;i<numberOfTimes;i++) {
            supplier.get();
        }
        return System.currentTimeMillis() - startTime;
    }

    public static int sumSequentialStream() {
        return IntStream.rangeClosed(0, 50000).sum();
    }

    public static int sumParallelStream() {
        return IntStream.rangeClosed(0, 50000).parallel().sum();
    }
}
