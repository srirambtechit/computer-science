package com.msrm.interview.algorithms.goldmansachtech;

import java.util.Arrays;

/**
 * <pre>
 * Given a set A with n integers, divide the set into two sets B and C such that
 * difference between sum of elements in B and sum of elements in C is minimum.
 * The return values should be the difference in sums.
 * 
 * Input: A - Array of integers
 * 
 * Output: D - the absolute values of the difference in the sum of two arrays.
 * 
 * Sample Input:-
 * A = [9, 3, 1, 2, 3, 3]
 * 
 * Sample Output:-
 * 1
 * 
 * Explanation:-
 * Set B = {3, 2, 3, 3} -- sum is 11
 * Set C = {9, 1} -------- sum is 10
 * Diff = 11 - 10 = 1
 * </pre>
 * 
 * @author sriram
 *
 */
public class ArrayPartitionProblem {

    public static void main(String[] args) {
	int[] a = { 9, 3, 1, 2, 3, 3 };
	System.out.println("Input : " + Arrays.toString(a));
	int diff = arrayPartition(a);
	System.out.println("Diff : " + diff);

    }

    public static int arrayPartition(int[] a) {
	return -1;
    }

}
