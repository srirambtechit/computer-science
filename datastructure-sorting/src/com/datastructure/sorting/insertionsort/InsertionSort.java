package com.datastructure.sorting.insertionsort;

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
public class InsertionSort {

    public static <T> void sort(Comparable<T>[] t) {

	// Assuming first element in array is sorted, so start loop from 1
	for (int i = 1; i < t.length; i++) {

	    // taking backup of data from array
	    Comparable<T> element = t[i];

	    // index j to traverse in reverse order to compare the backup data
	    int j = i;

	    // comparing element, if array value is greater than backup data,
	    // shift data to right of array
	    while (j > 0 && SortingUtil.greater(t[j - 1], element)) {
		SortingUtil.swap(t, j - 1, j);
		j--;
	    }

	    // fill up backup data to array at sorted index
	    if (j > 0 && SortingUtil.greater(t[j - 1], element)) {
		t[j + 1] = element;
	    }
	}

    }

    public static void main(String[] args) {
	SortingUtil.display(new Integer[] { 6, 5, 3, 1, 8, 7, 2, 4 }, Type.Insertion);
	SortingUtil.display(new Integer[] { 8, -1, 6, 0, 9, 4, 2, -57445, 3254, 245, 21017274 }, Type.Insertion);
	SortingUtil.display(new Integer[] {}, Type.Insertion);
    }

}
