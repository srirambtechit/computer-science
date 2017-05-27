package com.msrm.algorithms;

public class NumBinary {

    public static void main(String[] args) {
	NumBinary app = new NumBinary();
	int number = 62;
	System.out.println(Integer.toBinaryString(number));

	System.out.println();

	System.out.println(app.toBinarySolution1(number));
	System.out.println(app.toBinarySolution2(number));

    }

    public String toBinarySolution2(int number) {
	String result = "";
	while (number > 0) {
	    result = (number & 1) + result;
	    number = number >> 1;
	}
	return result;

    }

    /**
     * works only from 1 to 1023 numbers, beyond that range, integer overflow
     * occurred while type casting to int when the method returns
     * 
     * @param number
     * @return
     */
    public long toBinarySolution1(int number) {
	double trailingZeroCount = 0;
	int n = number;
	while (n % 2 == 0) {
	    trailingZeroCount++;
	    n = n / 2;
	}
	long result = 0;
	n = number;
	while (n > 0) {
	    result = result * 10 + n % 2;
	    n = n / 2;
	}
	return (long) (result * Math.pow(10.0, trailingZeroCount));
    }

}
