package com.msrm.algorithms.dynamicprogramming;

import java.util.Arrays;

public class MaxSumIncreasingSequence {

    public static void main(String[] args) {
	int[] nums = { 4, 6, 1, 3, 8, 4, 6 };
	int[] sequence = maxSumIncrSeq(nums);
	if (sequence != null) {
	    System.out.println(Arrays.toString(nums));
	    System.out.println(Arrays.stream(sequence).sum());
	}
	System.out.println();
	System.out.println(maxSum(nums));
    }

    // Directly calculates sum
    public static int maxSum(int arr[]) {
	int T[] = new int[arr.length];

	for (int i = 0; i < T.length; i++) {
	    T[i] = arr[i];
	}
	System.out.println(Arrays.toString(T));

	for (int i = 1; i < T.length; i++) {
	    for (int j = 0; j < i; j++) {
		if (arr[j] < arr[i]) {
		    T[i] = Math.max(T[i], T[j] + arr[i]);
		}
	    }
	}
	System.out.println(Arrays.toString(T));

	int max = T[0];
	for (int i = 1; i < T.length; i++) {
	    if (T[i] > max) {
		max = T[i];
	    }
	}
	return max;
    }

    public static int[] maxSumIncrSeq(int[] nums) {
	if (nums == null)
	    return null;
	int[] sums = new int[nums.length];
	int[] seqs = new int[nums.length];

	System.arraycopy(nums, 0, sums, 0, nums.length);
	for (int i = 0; i < nums.length; i++)
	    seqs[i] = i;

	for (int i = 1; i < nums.length; i++) {
	    for (int j = 0; j < i; j++) {
		if (nums[j] < nums[i]) {
		    if (sums[i] < sums[j] + nums[i]) {
			sums[i] = sums[j] + nums[i];
			seqs[i] = j;
		    }
		}
	    }
	}

	int m = maxIndex(sums);
	int[] result = new int[seqs.length];

	int i = 0;
	while (m != seqs[m]) {
	    result[i++] = nums[m];
	    m = seqs[m];
	}
	result[i] = nums[m];
	return result;
    }

    private static int maxIndex(int[] arr) {
	int max = 0;
	for (int i = 1; i < arr.length; i++) {
	    if (arr[i] > arr[max])
		max = i;
	}
	return max;
    }

}
