package com.example.exercises;

public class Factorial {

	public static void main(String[] args) {
		int num = 11;
		
		int total = num;
		for (int i=num; i>1; i--)
		{
			System.out.println(total + " * " + (i-1));
			total = total *  (i -1);
		}
		System.out.println(total);
		
		System.out.println(factorial(num));
	}
	
	private static int factorial(int num)
	{
		if (num == 0)
		{
			return 1;
		}
		return num*factorial(num -1);
	}

}
