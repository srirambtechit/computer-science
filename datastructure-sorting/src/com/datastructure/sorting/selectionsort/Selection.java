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
public class Selection {

    public static <T> void sort(Comparable<T>[] dataSet) {
	for (int i = 0; i < dataSet.length - 1; i++) {
	    int min = i;
	    for (int j = i + 1; j < dataSet.length; j++) {
		if (SortingUtil.less(dataSet, j, min)) {
		    min = j;
		}
	    }
	    SortingUtil.swap(dataSet, min, i);
	}

    }

    public static void main(String[] args) {
	SortingUtil.display(new Integer[] { 6, 5, 3, 1, 8, 7, 2, 4 }, Type.Selection);
	SortingUtil.display(new Integer[] { 8, -1, 6, 0, 9, 4, 2, -57445, 3254, 245, 21017274 }, Type.Selection);
	SortingUtil.display(new Integer[] {}, Type.Selection);
    }

}
