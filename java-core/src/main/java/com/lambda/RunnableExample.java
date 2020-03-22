package com.lambda;

public class RunnableExample {
	
	public static void main(String[] args) {
		
		
		// truyen thong
		Runnable runable1 = new Runnable() {
			
			@Override
			public void run() {
				int sum = 0;
				for(int i=0;i<100;i++) {
					sum += i;
				}
				System.out.println("total1: " + sum);
			}
		};
		
		new Thread(runable1).start();
		
		// lambda
		Runnable runable2 = () -> {
			int sum = 0;
			for(int i=0;i<100;i++) {
				sum += i;
			}
			System.out.println("total2: " + sum);
		};
		
		new Thread(runable2).start();
		
		// using thread lambda
		new Thread(()-> {
			int sum = 0;
			for(int i=0;i<100;i++) {
				sum += i;
			}
			System.out.println("total3: " + sum);
		}).start();
		
	}

}
