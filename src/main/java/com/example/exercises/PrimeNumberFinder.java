package com.example.exercises;

public class PrimeNumberFinder {

	final static double max = 20000;
		
	public static void main(String[] args) 
	{
		for (double number = 3; number < max; number++)
		{
			int sqrt = (int) Math.sqrt(number) + 1;
			boolean isPrime = true;
			
			if (number % 2 == 0) isPrime = false;
			
			if (isPrime)
			{
				for (int i = 3; i< sqrt; i=i+2)
				{
					if (number % i == 0)
					{
						isPrime = false;
						//System.out.println("can be divided by " + i);
						break;
					}
				}
			}
			if (isPrime) System.out.println(number + " is Prime");
		}
	}	
}
