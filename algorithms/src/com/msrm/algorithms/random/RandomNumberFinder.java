package com.msrm.algorithms.random;

/**
 * Find the randomly generated number. You can make use of
 * RandomNumberGenerator.checkNumber() method
 * 
 * @author sriram
 *
 */
public class RandomNumberFinder {
    private static RandomNumberGenerator rng = new RandomNumberGenerator();

    public static void main(String[] args) throws InterruptedException {

	// Brute force method - very expensive
	// solutionOne();

	// Optimized solution
	solutionTwo();

    }

    private static boolean isNegative() {
	int value = rng.checkNumber(-1);
	return value == 0 || value == -1;
    }

    private static boolean checkRange(int min, int max) {
	int minRange = rng.checkNumber(min);
	int maxRange = rng.checkNumber(max);
	return (minRange == 0 || minRange == 1) && (maxRange == 0 || maxRange == -1);
    }

    public static void solutionTwo() {
	// 1. Checking random number is singed or not
	// 2. Positive range checking +1 to +(2^31) - 1
	// 3. Negative rage checking -1 to -2^31

	// Point 1:- checking negative number
	if (isNegative()) {
	    // Point 3:- Checking negative range from 0 to Integer.MIN_VALUE
	    System.out.println("Negative");

	    int min = Integer.MIN_VALUE + 1, max = 0;
	    while (checkRange(min, max)) {
		int newMin = (max - min) / 2 + min;
		if (checkRange(newMin, newMin)) {
		    System.out.println("Found : " + newMin);
		    break;
		}
		if (checkRange(newMin, max)) {
		    min = newMin;
		}
		if (checkRange(min, newMin)) {
		    max = newMin;
		}
	    }
	} else {
	    // Point 2:- Checking positive range 0 to Integer.MAX_VALUE
	    System.out.println("Positive");
	    int min = 0, max = Integer.MAX_VALUE;

	    // code optimization
	    if (checkRange(Integer.MAX_VALUE, Integer.MAX_VALUE)) {
		System.out.println("Found : " + Integer.MAX_VALUE);
		return;
	    }
	    while (checkRange(min, max)) {
		int newMin = (max - min) / 2 + min;
		if (checkRange(newMin, newMin)) {
		    System.out.println("Found : " + newMin);
		    break;
		}
		if (checkRange(newMin, max)) {
		    min = newMin;
		}
		if (checkRange(min, newMin)) {
		    max = newMin;
		}
	    }
	}

    }

    public static void solutionOne() {
	for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
	    if (rng.checkNumber(i) == 0) {
		System.out.println("Found : " + i);
	    }
	}
    }

}
