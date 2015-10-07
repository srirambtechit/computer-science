package com.datastructure.sorting.mergesort;

import com.datastructure.sorting.util.SortingUtil;
import com.datastructure.sorting.util.Type;

/**
 * <pre>
 * 	Time 			Space 
 * BC - O(n log n), O(n)	O(n)
 * AC - O(n log n)		O(n)
 * WC - O(n log n)		O(n)
 * 
 * </pre>
 * 
 * @author sriram
 *
 */
public class Merge {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> void sort(Comparable<T>[] a) {
	if (a.length < 2) {
	    return;
	}

	int mid = a.length / 2;
	Comparable[] leftList = new Comparable[mid];
	Comparable[] rightList = new Comparable[a.length - mid];

	System.arraycopy(a, 0, leftList, 0, mid);
	System.arraycopy(a, mid, rightList, 0, a.length - mid);

	sort(leftList);
	sort(rightList);
	merge(leftList, rightList, a);
    }

    private static <T> void merge(Comparable<T>[] leftAux, Comparable<T>[] rightAux, Comparable<T>[] a) {
	int i = 0;
	int j = 0;
	int k = 0;

	while (i < leftAux.length && j < rightAux.length) {
	    if (SortingUtil.less(leftAux[i], rightAux[j])) {
		a[k++] = leftAux[i++];
	    } else {
		a[k++] = rightAux[j++];
	    }
	}

	while (i < leftAux.length) {
	    a[k++] = leftAux[i++];
	}

	while (j < rightAux.length) {
	    a[k++] = rightAux[j++];
	}

    }

    public static void main(String[] args) {
	SortingUtil.display(new Integer[] { 6, 5, 3, 1, 8, 7, 2, 4 }, Type.Merge);
	SortingUtil.display(new Integer[] { 8, -1, 6, 0, 9, 4, 2, -57445, 3254, 245, 21017274 }, Type.Merge);
	SortingUtil.display(new Integer[] {}, Type.Merge);
    }
}
