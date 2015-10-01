package com.datastructure.sorting.mergesort;

import com.datastructure.sorting.util.SortingUtil;
import com.datastructure.sorting.util.Type;

public class MergeSort {

    public static void mergeSort(int[] data) {
	if (data.length < 2) {
	    return;
	}

	int mid = data.length / 2;
	int[] leftList = new int[mid];
	int[] rightList = new int[data.length - mid];

	System.arraycopy(data, 0, leftList, 0, mid);
	System.arraycopy(data, mid, rightList, 0, data.length - mid);

	mergeSort(leftList);
	mergeSort(rightList);
	merge(leftList, rightList, data);
    }

    private static void merge(int[] leftList, int[] rightList, int[] data) {
	int i = 0;
	int j = 0;
	int k = 0;

	while (i < leftList.length && j < rightList.length) {
	    if (leftList[i] < rightList[j]) {
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
	SortingUtil.display(new int[] { 6, 5, 3, 1, 8, 7, 2, 4 }, Type.Merge);
	SortingUtil.display(new int[] { 8, -1, 6, 0, 9, 4, 2, -57445, 3254, 245, 21017274 }, Type.Merge);
	SortingUtil.display(new int[] {}, Type.Merge);
    }
}
