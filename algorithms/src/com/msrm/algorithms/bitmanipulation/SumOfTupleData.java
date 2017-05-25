package com.msrm.algorithms.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class SumOfTupleData {

    public static void main(String[] args) {
	int[] arr = { 2, 3, 1, -3, 4, -5 };
	int tuple = 3;
	int sum = 0;
	System.out.println(sumOfTupleSet(arr, tuple, sum));
    }

    static List<List<Integer>> sumOfTupleSet(int[] arr, int tuple, int sum) {

	List<List<Integer>> tuples = new ArrayList<>();
	// 1. construct maximum bit string
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < arr.length; i++) {
	    sb.append('1');
	}

	// 2. Loop till maximum bit string becomes 0
	String bits = sb.toString();
	for (int i = Integer.parseInt(bits, 2); i > 0; i--) {
	    if (tuple == countBit(i)) {
		bits = Integer.toString(i, 2);
		int tupleSum = 0;
		List<Integer> group = new ArrayList<>();
		for (int j = bits.length() - 1; j >= 0; j--) {
		    if ('1' == bits.charAt(j)) {
			int element = arr[arr.length - 1 - (bits.length() - 1 - j)];
			tupleSum += element;
			group.add(element);
		    }
		}
		if (tupleSum == sum) {
		    tuples.add(group);
		}
	    }
	}
	return tuples;
    }

    static int countBit(int n) {
	int c = 0;
	while (n > 0) {
	    c = c + (n & 1);
	    n = n >>> 1;
	}
	return c;
    }

}
