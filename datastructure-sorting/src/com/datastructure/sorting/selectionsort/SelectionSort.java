package com.datastructure.sorting.selectionsort;

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
public class SelectionSort {

    public static void selectionSort(int[] t) {
	for (int i = 0; i < t.length - 1; i++) {
	    int min = i;
	    for (int j = i + 1; j < t.length; j++) {
		if (SortingUtil.less(t, j, min)) {
		    min = j;
		}
	    }
	    SortingUtil.swap(t, min, i);
	}

    }

    public static void main(String[] args) {
	SortingUtil.display(new int[] { 6, 5, 3, 1, 8, 7, 2, 4 }, Type.Selection);
	SortingUtil.display(new int[] { 8, -1, 6, 0, 9, 4, 2, -57445, 3254, 245, 21017274 }, Type.Selection);
	SortingUtil.display(new int[] {}, Type.Selection);
    }

}
