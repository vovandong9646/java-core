package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class SumOfNumbersUsingCallable {
	public static int[] array = IntStream.rangeClosed(0, 5000).toArray();
	public static int total = IntStream.rangeClosed(0, 5000).sum();
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<Integer> callable1 = () -> {
			int sum = 0;
			for(int i=0;i<array.length/2;i++) {
				sum+=array[i];
			}
			return sum;
		};
		
		Callable<Integer> callable2 = () -> {
			int sum = 0;
			for(int i=array.length/2;i<array.length;i++) {
				sum+=array[i];
			}
			return sum;
		};
		
		List<Callable<Integer>> callableList = Arrays.asList(callable1, callable2);
		ExecutorService service = Executors.newFixedThreadPool(2);
		List<Future<Integer>> results = service.invokeAll(callableList);
		
		int sum = 0;
		
		for (Future<Integer> result : results) {
			sum += result.get();
		}
		
		System.out.println(sum);
		System.out.println(total);
	}
	
	
	
}
