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
public class MergeSort {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> void sort(Comparable<T>[] dataSet) {
	if (dataSet.length < 2) {
	    return;
	}

	int mid = dataSet.length / 2;
	Comparable[] leftList = new Comparable[mid];
	Comparable[] rightList = new Comparable[dataSet.length - mid];

	System.arraycopy(dataSet, 0, leftList, 0, mid);
	System.arraycopy(dataSet, mid, rightList, 0, dataSet.length - mid);

	sort(leftList);
	sort(rightList);
	merge(leftList, rightList, dataSet);
    }

    private static <T> void merge(Comparable<T>[] leftList, Comparable<T>[] rightList, Comparable<T>[] data) {
	int i = 0;
	int j = 0;
	int k = 0;

	while (i < leftList.length && j < rightList.length) {
	    if (SortingUtil.less(leftList[i], rightList[j])) {
		data[k++] = leftList[i++];
	    } else {
		data[k++] = rightList[j++];
	    }
	}

	while (i < leftList.length) {
	    data[k++] = leftList[i++];
	}

	while (j < rightList.length) {
	    data[k++] = rightList[j++];
	}

    }

    public static void main(String[] args) {
	SortingUtil.display(new Integer[] { 6, 5, 3, 1, 8, 7, 2, 4 }, Type.Merge);
	SortingUtil.display(new Integer[] { 8, -1, 6, 0, 9, 4, 2, -57445, 3254, 245, 21017274 }, Type.Merge);
	SortingUtil.display(new Integer[] {}, Type.Merge);
    }
}
