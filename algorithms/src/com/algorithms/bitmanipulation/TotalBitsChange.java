package com.algorithms.bitmanipulation;

/**
 * Write a program to find out number of bits that will need to be changed in
 * order to convert an integer X into another integer Y and vice versa. The
 * method should accept two different integer as input. For example, if your
 * method is passed the integers 12 and 16 then your method should return 3
 * 
 * @author sriram
 *
 */
public class TotalBitsChange {

    public static void main(String[] args) {
	int n1 = -1;
	int n2 = 33;
	System.out.printf("noOfBitChanges(%d, %d) = %d%n", n1, n2, noOfBitChanges(n1, n2));
    }

    public static int noOfBitChanges(int number1, int number2) {
	int bitCount = 0;
	int xor = number1 ^ number2;
	while (xor != 0) {
	    bitCount += xor & 1;
	    xor = xor >>> 1;
	}
	return bitCount;
    }
}
