package com.datastructure.sorting.mergesort.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import com.datastructure.sorting.mergesort.MergeSort;

public class MergeSortTest {

    @Test
    public void testMergeSort_1() {
	System.out.println("Case 1: Array with pass scenario");
	int[] input = { 3, 2, 8, 1, 7, 9, 5, 0 };
	int[] output = new int[input.length];
	System.arraycopy(input, 0, output, 0, input.length);

	MergeSort.sort(output);
	Arrays.sort(input);

	assertArrayEquals("Both are equal", input, output);
    }

    @Test
    public void testMergeSort_2() {
	System.out.println("Case 2: Empty array");
	int[] input = {};
	int[] output = new int[input.length];
	System.arraycopy(input, 0, output, 0, input.length);

	MergeSort.sort(output);
	Arrays.sort(input);

	assertArrayEquals("Both are equal", input, output);
    }

    @Test
    public void testMergeSort_3() {
	System.out.println("Case 3: Array with duplicate elements");
	int[] input = { 3, 2, 8, 3, 7, 9, 5, -2, 0, 3, 7, 2, 6, 1, -1, 9 };
	int[] output = new int[input.length];
	System.arraycopy(input, 0, output, 0, input.length);

	MergeSort.sort(output);
	Arrays.sort(input);

	assertArrayEquals("Both are equal", input, output);
    }

}
