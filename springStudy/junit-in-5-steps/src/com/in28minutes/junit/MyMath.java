package com.in28minutes.junit;

public class MyMath {
	
	int sum(int[] numbers) {
		
		int sum = 0;
		for (int i = 1; i <= numbers.length; i++) {
			sum +=  i;
		}
		return sum;
	}
}
