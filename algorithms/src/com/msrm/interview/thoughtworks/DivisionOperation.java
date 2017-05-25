package com.msrm.interview.thoughtworks;

/**
 * Division without using / % operator
 * 
 * @author Sriram
 *
 */
public class DivisionOperation {

    public static void main(String[] args) {
	DivisionOperation op = new DivisionOperation();
	System.out.println(op.div(99, 1));
    }

    public int div(int numerator, int denominator) {
	if (denominator == 0) {
	    throw new ArithmeticException("division by zero : " + numerator + "/" + denominator);
	}

	boolean negNumerator = false;
	boolean negDenominator = false;
	if (!isPositive(numerator)) {
	    numerator = -numerator;
	    negNumerator = true;
	}
	if (!isPositive(denominator)) {
	    denominator = -denominator;
	    negDenominator = true;
	}

	int quotient = 0;
	while (numerator >= denominator) {
	    numerator = numerator - denominator;
	    quotient++;
	}

	if (negDenominator && negNumerator) {
	    return quotient;
	} else if (negDenominator || negNumerator) {
	    return -quotient;
	}
	return quotient;
    }

    public boolean isPositive(int number) {
	return (number >>> 31) == 0;
    }

}
