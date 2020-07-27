package com.imricki.maxoptra.app;

/**
 * 
 * @author Ricardo Vargas
 * @version 1.0
 *
 */
public class App {

	public static void main(String[] args) {

		Integer num = 17;

		if (num == (int) num) {
			System.out.println("The number is: " + operation(num));
		}

	}

	public static Integer operation(int numberInput) {

		Integer sumOfNumbers = 0;

		while (numberInput > 0) {
			sumOfNumbers = sumOfNumbers + numberInput % 10;
			numberInput = numberInput / 10;
		}

		return sumOfNumbers;

	}

}
