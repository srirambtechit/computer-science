package com.datastructure.sorting.insertionsort;

import java.util.Arrays;

import com.datastructure.sorting.util.SortingUtil;

public class InsertionSort {

    public static void insertionSort(Integer[] t) {

	// Assuming first element in array is sorted, so start loop from 1
	for (int i = 1; i < t.length; i++) {

	    // taking backup of data from array
	    int element = t[i];

	    // index j to traverse in reverse order to compare the backup data
	    int j = i;

	    // comparing element, if array value is greater than backup data,
	    // shift data to right of array
	    while (j > 0 && t[j - 1] > element) {
		SortingUtil.swap(t, j - 1, j);
		j--;
	    }

	    // fill up backup data to array at sorted index
	    if (j > 0 && t[j - 1] > element) {
		t[j + 1] = element;
	    }
	}

    }

    public static void main(String[] args) {
	Integer[] data = { 6, 5, 3, 1, 8, 7, 2, 4 };
	System.out.println(Arrays.toString(data));
	insertionSort(data);
	System.out.println(Arrays.toString(data));
    }

}
