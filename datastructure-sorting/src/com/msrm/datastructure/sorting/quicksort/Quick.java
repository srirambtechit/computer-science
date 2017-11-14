package com.msrm.datastructure.sorting.quicksort;

import com.msrm.datastructure.sorting.util.SortingUtil;
import com.msrm.datastructure.sorting.util.Type;

/**
 * <pre>
 * Time:-
 * 	BC - O(n log n)
 * 	AC - O(n log n)
 * 	WC - O(1/2 n^2)
 * 
 * Space   - O(n)
 * 
 * </pre>
 * 
 * @author sriram
 *
 */
public class Quick {

	public static <T> void sort(Comparable<T>[] t) {

		// To improve better performance
		SortingUtil.shffle(t);

		sort(t, 0, t.length - 1);
	}

	/**
	 * <pre>
	 * Divide and conquer method to solve problem. 
	 * Function to split problems into subproblems to solve recursively.
	 * 
	 * &#64;param a - input array
	 * &#64;param low - lower index in an array
	 * &#64;param high - higher index in an array
	 * </pre>
	 */
	private static <T> void sort(Comparable<T>[] a, int low, int high) {
		if (low < high) {
			int i = partition(a, low + 1, high);
			sort(a, low, i - 1);
			sort(a, i + 1, high);
		}
	}

	/**
	 * <pre>
	 * Calculating partition point based pivot value.
	 * 
	 * &#64;param a - array of integer as input
	 * &#64;param low - lower index of an array
	 * &#64;param high - higher index of an array
	 * &#64;return partition point
	 * </pre>
	 */
	private static <T> int partition(Comparable<T>[] a, int low, int high) {
		// Always pivot will be first element in array
		int pivot = low - 1;

		do {
			// Moving low pointer when it less than pivot
			while (SortingUtil.less(a[low], a[pivot]))
				low++;

			// Moving high pointer when it greater than pivot
			while (SortingUtil.greater(a[high], a[pivot]))
				high--;

			// Crossed low and high pointer, exchange data
			if (low < high) {
				SortingUtil.swap(a, low, high);
			}

		} while (low < high);

		// Exchange pivot with high pointer position
		SortingUtil.swap(a, pivot, high);

		return high;
	}

	public static void main(String[] args) {
		SortingUtil.display(new Integer[]{4, 2, 8, -1, 7, 0, 9, 5, 13}, Type.Quick);
		SortingUtil.display(new Integer[]{6, 5, 3, 1, 8, 7, 2, 4}, Type.Quick);
		SortingUtil.display(new Integer[]{8, -1, 6, 0, 9, 4, 2, -57445, 3254, 245, 21017274}, Type.Quick);
		SortingUtil.display(new Integer[]{}, Type.Quick);
	}

}