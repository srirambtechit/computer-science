package com.msrm.algorithms;

public class NumBinary {

    public static void main(String[] args) {
	NumBinary app = new NumBinary();
	int result = app.toBinary(1023);
	System.out.println(result);
    }

    /**
     * works only from 1 to 1023 numbers, beyond that range, integer overflow
     * occurred while type casting to int when the method returns
     * 
     * @param number
     * @return
     */
    public int toBinary(int number) {
	double trailingZeroCount = 0;
	int n = number;
	while (n % 2 == 0) {
	    trailingZeroCount++;
	    n = n / 2;
	}
	int result = 0;
	n = number;
	while (n > 0) {
	    result = result * 10 + n % 2;
	    n = n / 2;
	}
	return (int) (result * Math.pow(10.0, trailingZeroCount));
    }

}
