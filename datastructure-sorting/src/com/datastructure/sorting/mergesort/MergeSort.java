package com.datastructure.sorting.mergesort;

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

}
