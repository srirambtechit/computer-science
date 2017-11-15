package com.msrm.algorithms.util;

import java.util.Arrays;

public class ProgramUtil {

    public static int[] numbers(int n) {
	return numbers(n, 100);
    }

    public static int[] numbers(int n, int maxRange) {
	int[] numbers = new int[n];
	for (int i = 0; i < n; i++)
	    numbers[i] = (int) (Math.random() * maxRange);
	return numbers;
    }

    public static int[] numbers(int n, int[] mandates) {
	assert n > 0;
	int[] numbers = numbers(n);
	for (int i = 0; i < n / 2; i++) {
	    numbers[i] = mandates[i];
	}
	return numbers;
    }

    public static int[] sortedNumbers(int n) {
	int[] numbers = numbers(n);
	Arrays.sort(numbers);
	return numbers;
    }

    public static int[] sortedNumbers(int n, int[] mandates) {
	int[] numbers = numbers(n, mandates);
	Arrays.sort(numbers);
	return numbers;
    }
}
