package com.lambda;

public class HelloWorldTraditional implements HelloWorldInterface {

	public String sayHelloWorld() {
		return "hello world";
	}
	
	public static void main(String[] args) {
		HelloWorldTraditional helloWorldTraditional = new HelloWorldTraditional();
		System.out.println(helloWorldTraditional.sayHelloWorld());
	}

}
