package com.lambda;

public class IncrementByFiveTraditional implements IncrementByFiveInterface {

	@Override
	public int incrementByFive(int a) {
		return a + 5;
	}
	
	public static void main(String[] args) {
		IncrementByFiveTraditional traditional = new IncrementByFiveTraditional();
		System.out.println(traditional.incrementByFive(2));
	}

}
