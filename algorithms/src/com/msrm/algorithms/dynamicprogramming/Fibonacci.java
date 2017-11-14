package com.msrm.algorithms.dynamicprogramming;

import java.util.Arrays;

public class Fibonacci {

    private static int[] arr = new int[50];

    static {
	Arrays.fill(arr, -1);
	arr[1] = 0;
	arr[2] = 1;
    }

    public static void main(String[] args) {
	for (int n = 1; n <= 47; n++) {
	    System.out.printf("fib(%d) : %d%n", n, fib(n));
	}
    }

    private static int fib(int n) {
	if (n == 0)
	    throw new IllegalArgumentException("n > 0");

	if (n == 1 || n == 2 || arr[n] != -1)
	    return arr[n];

	arr[n] = fib(n - 1) + fib(n - 2);
	return arr[n];
    }
}
