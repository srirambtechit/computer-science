package com.datastructure.sorting.util;

import java.util.Arrays;

import com.datastructure.sorting.bubblesort.BubbleSort;
import com.datastructure.sorting.insertionsort.InsertionSort;
import com.datastructure.sorting.mergesort.MergeSort;

public class SortingUtil {

    public static void swap(int[] o, int i, int j) {
	int t = o[i];
	o[i] = o[j];
	o[j] = t;
    }

    public static void display(int[] dataSet, Type type) {
	System.out.println(type + " Sorting");
	System.out.println(Arrays.toString(dataSet));
	doSort(dataSet, type);
	System.out.println(Arrays.toString(dataSet));
	System.out.println();
    }

    private static void doSort(int[] dataSet, Type type) {
	switch (type) {
	case Bubble:
	    BubbleSort.bubbleSort(dataSet);
	    break;
	case Bubble_Optimized:
	    BubbleSort.bubbleSortOptimized(dataSet);
	    break;
	case Insertion:
	    InsertionSort.insertionSort(dataSet);
	    break;
	case Merge:
	    MergeSort.mergeSort(dataSet);
	    break;
	}
    }

}
