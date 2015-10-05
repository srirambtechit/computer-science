package com.datastructure.sorting.quicksort;

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
public class QuickSort {

    public static void sort(int[] t) {
    }

    public static void main(String[] args) {
	SortingUtil.display(new int[] { 6, 5, 3, 1, 8, 7, 2, 4 }, Type.Selection);
	SortingUtil.display(new int[] { 8, -1, 6, 0, 9, 4, 2, -57445, 3254, 245, 21017274 }, Type.Selection);
	SortingUtil.display(new int[] {}, Type.Selection);
    }

}
