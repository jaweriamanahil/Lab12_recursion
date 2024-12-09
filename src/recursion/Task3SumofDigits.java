package recursion;

import java.util.Scanner;

public class Task3SumofDigits {

    // Recursive function to calculate the sum of digits
	public static int sumOfDigits(int number) {
	    if (number == Integer.MIN_VALUE) {
	        // Handle Integer.MIN_VALUE separately
	        return sumOfDigits(Integer.MAX_VALUE) + 1; // Integer.MAX_VALUE is 2147483647
	    }

	    if (number < 0) {
	        number = -number; // Convert negative to positive
	    }

	    if (number == 0) {
	        return 0; // Base case
	    }

	    return (number % 10) + sumOfDigits(number / 10); // Recursive step
	}



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();  // Read user input

        System.out.println("Sum of digits: " + sumOfDigits(number));
        
        scanner.close();  // Close the scanner resource
    }
}
