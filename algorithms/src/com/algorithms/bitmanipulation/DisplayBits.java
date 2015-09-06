package com.algorithms.bitmanipulation;

public class DisplayBits {

    public static void main(String[] args) {
	int n = 100;
	System.out.printf("%d is %s%n", n, displayBinaryForm(n));
	System.out.println("Binary form : " + Integer.toBinaryString(n));
    }

    public static String displayBinaryForm(int n) {

	StringBuilder builder = new StringBuilder();

	while (n != 0) {
	    if ((n & 1) == 1) {
		builder.insert(0, 1);
	    } else {
		builder.insert(0, 0);
	    }
	    n = n >>> 1;
	}
	return builder.toString();
    }

}
