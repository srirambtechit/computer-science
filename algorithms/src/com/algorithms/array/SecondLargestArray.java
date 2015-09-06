package com.algorithms.array;

public class SecondLargestArray {

    public static void main(String[] args) {
	int[] arr = { 3, 8, 2, 9, 7, 1, 10 };
	int no = find2ndLargest(arr);
	System.out.println("Ans is : " + no);
    }

    public static int find2ndLargest(int[] arr) {
	if (arr == null || arr.length == 0)
	    throw new IllegalArgumentException("Input is empty");

	int maxOne = Integer.MIN_VALUE, maxTwo = Integer.MIN_VALUE;

	if (arr.length > 0)
	    maxOne = arr[0];

	if (arr.length > 1)
	    maxTwo = arr[1];

	// ensuring that maxOne has higher value than maxTwo
	if (maxOne < maxTwo) {
	    int t = maxTwo;
	    maxTwo = maxOne;
	    maxOne = t;
	}

	for (int i = 2; i < arr.length; i++) {
	    if (maxTwo < arr[i]) {
		if (maxOne < arr[i]) {
		    maxTwo = maxOne;
		    maxOne = arr[i];
		} else {
		    maxTwo = arr[i];
		}
	    }
	}

	return maxTwo;
    }

}
