package com.lambda;

public class HelloWorldLambda {
	public static void main(String[] args) {
		// implementing sayHelloWorld using lambda
		HelloWorldInterface helloWorldInterface = () -> {
			return "hello world lambda";
		};
		
		System.out.println(helloWorldInterface.sayHelloWorld());
	}
}
