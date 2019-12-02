/*------------------------------------------------------
My name: Daniel Parise
My subject code: CSIT111
Assignment number: 2
-------------------------------------------------------*/

import java.util.Scanner;

class OprWithComplexNumbers { 

	private static ComplexNumber resSum;
	private static ComplexNumber resDifference;
	private static ComplexNumber resProduct;

	public static void main(String[] args) {
		// User input which declares variables used locally in main method
		double inputReal1, inputReal2, inputImaginary1, inputImaginary2; 
		
		// Declaring two references for the complex numbers
		ComplexNumber compNum1, compNum2;  
		
		// Initiates Scanner Object
		Scanner input = new Scanner(System.in); 

		System.out.println("--- Basic arithmetic operations with complex numbers ---");
		System.out.print("Enter the first complex number in the format r i: ");
		
		// Receives first input for real number
		inputReal1 = input.nextDouble(); 
		
		// Recieves first input for imaginary number
		inputImaginary1 = input.nextDouble(); 
		
        // Wipes the scanner input buffer
		input.nextLine(); 

		System.out.print("Enter the second complex number in the format r i: ");
		
		// Receives second input for real number
		inputReal2 = input.nextDouble(); 
		
		// Receives second input for imaginary number
		inputImaginary2 = input.nextDouble(); 

		// Instantiates the first complex number
		compNum1 = new ComplexNumber(inputReal1, inputImaginary1); 
		
		// Instantiates the second complex number
		compNum2 = new ComplexNumber(inputReal2, inputImaginary2); 
		
		// Calculates the results from the first and second complex number
		calculateResults(compNum1, compNum2); 

		// Displays the calculated results
		displayResults(compNum1, compNum2); 

		System.out.println("--- The program has terminated ---");
	}

	public static void calculateResults(ComplexNumber compNum1, ComplexNumber compNum2) {
		// Instantiates the calculator using the two complex numbers method argument
		Calculator calculator = new Calculator(compNum1, compNum2); 

		// Initiates the resSum as a static variable for sum of two numbers
		resSum = calculator.addTwoNumbers(); 
		
		// Initiates the resDifference as a static variable for difference of two numbers
		resDifference = calculator.subTwoNumbers(); 
		
		// Initiates the resProduct as a static variable for the product of two numbers
		resProduct = calculator.mulTwoNumbers(); 
	}

	// Displays all results
	public static void displayResults(ComplexNumber compNum1, ComplexNumber compNum2) {
		
	    System.out.printf("(%.1f, %.1f) + (%.1f, %.1f) = (%.1f, %.1f)\n", compNum1.real, compNum1.imaginary, compNum2.real, compNum2.imaginary, resSum.real, resSum.imaginary);
		System.out.printf("(%.1f, %.1f) - (%.1f, %.1f) = (%.1f, %.1f)\n", compNum1.real, compNum1.imaginary, compNum2.real, compNum2.imaginary, resDifference.real, resDifference.imaginary);
		System.out.printf("(%.1f, %.1f) * (%.1f, %.1f) = (%.1f, %.1f)\n", compNum1.real, compNum1.imaginary, compNum2.real, compNum2.imaginary, resProduct.real, resProduct.imaginary);
	}

}

class Calculator {

	private ComplexNumber compNum1;
	private ComplexNumber compNum2;

	public Calculator(ComplexNumber compNum1, ComplexNumber compNum2) { 
		
		this.compNum1 = compNum1; 
		this.compNum2 = compNum2;
	}

	// Returns the result as a complex number of the sum of the two complex numbers 
	public ComplexNumber addTwoNumbers() {
		
		double resReal = compNum1.real + compNum2.real;
		double resImaginary = compNum1.imaginary + compNum2.imaginary;
		return new ComplexNumber(resReal, resImaginary);
	}

	// Returns the result as a complex number of the difference of the two complex numbers
	public ComplexNumber subTwoNumbers() {
		
		double resReal = compNum1.real - compNum2.real;
		double resImaginary = compNum1.imaginary - compNum2.imaginary;
		return new ComplexNumber(resReal, resImaginary);
	}

	// Returns the result as a complex number of the product of the two complex numbers
	public ComplexNumber mulTwoNumbers() {
		
		double resReal = compNum1.real * compNum2.real - compNum1.imaginary * compNum2.imaginary;
		double resImaginary = compNum1.real * compNum2.imaginary + compNum1.imaginary * compNum2.real;
		return new ComplexNumber(resReal, resImaginary);
	}

}

class ComplexNumber {

	public double real;
	public double imaginary;

	public ComplexNumber(double real, double imaginary) {
		
		this.real = real;
		this.imaginary = imaginary;
	}

}
