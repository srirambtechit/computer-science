package com.datastructure.sorting.bubblesort;

import java.util.Arrays;

import com.datastructure.sorting.util.SortingUtil;

public class BubbleSort {

    /**
     * Basic algorithm
     * 
     * @param t
     */
    public static void bubbleSort(Integer[] t) {

	// extending the logic to N elements
	for (int i = 0; i < t.length; i++) {

	    // below loop do the actual sorting
	    for (int j = 1; j < t.length; j++) {
		if (t[j - 1] > t[j]) {
		    SortingUtil.swap(t, j, j - 1);
		}
	    }
	}

    }

    /**
     * It avoids already sorted element to check once again
     * 
     * @param t
     */
    public static void bubbleSortOptimized(Integer[] t) {

	for (int i = t.length - 1; i >= 0; i--) {

	    // Below loop ensures that 1 element sorted and kept in last index
	    // of array N, N-1, N-2 in each iteration of the loop
	    for (int j = 1; j < i; j++) {
		if (t[j - 1] > t[j]) {
		    SortingUtil.swap(t, j, j - 1);
		}
	    }
	}
    }

    public static void main(String[] args) {
	Integer[] data = new Integer[] { 5, 1, 4, 2, 8 };
	System.out.println(Arrays.toString(data));
	bubbleSortOptimized(data);
	System.out.println(Arrays.toString(data));
    }

}
