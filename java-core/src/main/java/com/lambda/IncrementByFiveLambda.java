package com.lambda;

public class IncrementByFiveLambda {
	
	public static void main(String[] args) {
//		IncrementByFiveInterface interf = (a) -> {
//			return a + 5;
//		};
		
		IncrementByFiveInterface interf = a -> a + 5;
		System.out.println(interf.incrementByFive(2));
	}
	
	
	

}
