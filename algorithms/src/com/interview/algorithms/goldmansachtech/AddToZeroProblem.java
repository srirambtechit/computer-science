package com.interview.algorithms.goldmansachtech;

import java.util.Arrays;

/**
 * <pre>
 * Given an array of n-integers, return an array of 3 indexes in the array, such
 * that the elements at those indexes add to zero. Assume there exists 1 unique solution.
 * 
 * i.e. a[i] + a[j] + a[k] = 0
 * Note: indexes should be in increasing order i < j < k
 * 
 * Sample Input:
 * A = [-4, 5, -15, 7, -3, 2, 4]
 * 
 * Sample Output:
 * 0, 3, 4
 * 
 * </pre>
 * 
 * @author sriram
 *
 */

public class AddToZeroProblem {

    public static void main(String[] args) {
	int[] data = { -4, 5, 2, -15, 7, -3, 2, 4 };
	System.out.println("Input : " + Arrays.toString(data));
	int[] result = addToZero(data);
	System.out.println("Output : " + Arrays.toString(result));
    }

    /**
     * This method will return the indexes whose summation equals to zero in
     * ascending order. If there is no expected value, resultant array would
     * have -1s
     */
    public static int[] addToZero(int[] a) {
	int[] ri = new int[3];
	int sum;
	int i, j, k;
	i = j = k = 0;

	out: for (i = 0; i < a.length; i++) {
	    for (j = i + 1; j < a.length; j++) {
		for (k = j + 1; k < a.length; k++) {
		    sum = a[i] + a[j] + a[k];
		    if (sum == 0) {
			break out;
		    }
		}
	    }
	}

	// Expected sum not found
	if (i == j && j == k) {
	    i = j = k = -1;
	}

	ri[0] = i;
	ri[1] = j;
	ri[2] = k;
	return ri;
    }

}
