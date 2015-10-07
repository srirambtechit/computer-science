package com.datastructure.sorting.mergesort.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import com.datastructure.sorting.mergesort.Merge;

public class MergeTest {

    @Test
    public void testMergeSort_1() {
	System.out.println("Case 1: Array with pass scenario");
	Integer[] input = { 3, 2, 8, 1, 7, 9, 5, 0 };
	Integer[] output = new Integer[input.length];
	System.arraycopy(input, 0, output, 0, input.length);

	Merge.sort(output);
	Arrays.sort(input);

	assertArrayEquals("Both are equal", input, output);
    }

    @Test
    public void testMergeSort_2() {
	System.out.println("Case 2: Empty array");
	Integer[] input = {};
	Integer[] output = new Integer[input.length];
	System.arraycopy(input, 0, output, 0, input.length);

	Merge.sort(output);
	Arrays.sort(input);

	assertArrayEquals("Both are equal", input, output);
    }

    @Test
    public void testMergeSort_3() {
	System.out.println("Case 3: Array with duplicate elements");
	Integer[] input = { 3, 2, 8, 3, 7, 9, 5, -2, 0, 3, 7, 2, 6, 1, -1, 9 };
	Integer[] output = new Integer[input.length];
	System.arraycopy(input, 0, output, 0, input.length);

	Merge.sort(output);
	Arrays.sort(input);

	assertArrayEquals("Both are equal", input, output);
    }

}
