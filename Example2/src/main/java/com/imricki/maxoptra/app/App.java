package com.imricki.maxoptra.app;

public class App {

	
	public static void main(String[] args) {
		
		Integer num=17;
		
		if (num == (int)num)
		{
			operation(num);
		}
		
	}
	
	
	public  static void operation(int number) {
		
		Integer sumOfNumbers = 0;
		
	        
	        while (number > 0) {
	            sumOfNumbers = sumOfNumbers + number % 10;
	            number = number / 10;
	        }
	      
	        
	}
	
	
}
