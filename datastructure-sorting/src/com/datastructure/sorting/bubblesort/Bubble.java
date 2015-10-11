package com.datastructure.sorting.bubblesort;

import com.datastructure.sorting.util.SortingUtil;
import com.datastructure.sorting.util.Type;

/**
 * <pre>
 * 	Time 	Space 
 * BC - O(n)	O(1)
 * AC - O(n^2)	O(1)
 * WC - O(n^2)	O(1)
 * 
 * </pre>
 * 
 * @author sriram
 *
 */
public class Bubble {

    /**
     * Basic algorithm
     * 
     * @param a
     */
    public static <T> void sort(Comparable<T>[] a) {

	// extending the logic to N elements
	for (int i = 0; i < a.length; i++) {

	    // below loop do the actual sorting
	    for (int j = 1; j < a.length; j++) {
		if (SortingUtil.greater(a[j - 1], a[j])) {
		    SortingUtil.swap(a, j, j - 1);
		}
	    }
	}

    }

    /**
     * It avoids already sorted element to check once again
     * 
     * @param a
     */
    public static <T> void bubbleSortOptimized(Comparable<T>[] a) {

	for (int i = a.length - 1; i >= 0; i--) {

	    // Below loop ensures that 1 element sorted and kept in last index
	    // of array N, N-1, N-2 in each iteration of the loop
	    for (int j = 1; j < i; j++) {
		if (SortingUtil.greater(a[j - 1], a[j])) {
		    SortingUtil.swap(a, j, j - 1);
		}
	    }
	}
    }

    public static void main(String[] args) {
	SortingUtil.display(new Integer[] { 5, 1, 4, 2, 8 }, Type.Bubble);
	SortingUtil.display(new Integer[] { 6, 5, 3, 1, 8, 7, 2, 4 }, Type.Bubble);
	SortingUtil.display(new Integer[] { 8, -1, 6, 0, 9, 4, 2, -57445, 3254, 245, 21017274 }, Type.Bubble);
	SortingUtil.display(new Integer[] {}, Type.Bubble);

	SortingUtil.display(new Integer[] { 5, 1, 4, 2, 8 }, Type.Bubble_Optimized);
	SortingUtil.display(new Integer[] { 6, 5, 3, 1, 8, 7, 2, 4 }, Type.Bubble_Optimized);
	SortingUtil.display(new Integer[] { 8, -1, 6, 0, 9, 4, 2, -57445, 3254, 245, 21017274 }, Type.Bubble_Optimized);
	SortingUtil.display(new Integer[] {}, Type.Bubble_Optimized);
    }

}
