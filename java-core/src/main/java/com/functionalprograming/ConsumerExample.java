package com.functionalprograming;

import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {

		Consumer<String> introduce = name -> System.out.println("hello: " + name);
		introduce.accept("DongVV2");

		Consumer<Integer> d = (x) -> {
			System.out.println("x*x="+ x *x);
			System.out.println("x/x="+ x/x);
		};
		d.accept(10);

	}
}
