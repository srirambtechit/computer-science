package com.msrm.datastructure.sorting.util;

import java.util.Arrays;
import java.util.Random;

import com.msrm.datastructure.sorting.bubblesort.Bubble;
import com.msrm.datastructure.sorting.heapsort.Heap;
import com.msrm.datastructure.sorting.insertionsort.Insertion;
import com.msrm.datastructure.sorting.mergesort.Merge;
import com.msrm.datastructure.sorting.quicksort.Quick;
import com.msrm.datastructure.sorting.selectionsort.Selection;

public class SortingUtil {

    public static <T> void display(Comparable<T>[] a, Type type) {
	System.out.println(type + " Sorting");
	System.out.println(Arrays.toString(a));
	doSort(a, type);
	System.out.println(Arrays.toString(a));
	System.out.println();
    }

    private static <T> void doSort(Comparable<T>[] a, Type type) {
	switch (type) {
	case Bubble:
	    Bubble.sort(a);
	    break;
	case Bubble_Optimized:
	    Bubble.bubbleSortOptimized(a);
	    break;
	case Insertion:
	    Insertion.sort(a);
	    break;
	case Merge:
	    Merge.sort(a);
	    break;
	case Selection:
	    Selection.sort(a);
	    break;
	case Quick:
	    Quick.sort(a);
	    break;
	case Heap:
	    Heap.sort(a);
	    break;
	}
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> boolean greater(Comparable c1, Comparable c2) {
	return c1.compareTo(c2) > 0;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> boolean less(Comparable c1, Comparable c2) {
	return c1.compareTo(c2) < 0;
    }

    public static <T> void swap(Comparable<T>[] o, int i, int j) {
	Comparable<T> t = o[i];
	o[i] = o[j];
	o[j] = t;
    }

    public static <T> void shffle(Comparable<T>[] o) {
	int size = o.length - 1;
	for (int i = 0; i < o.length / 2; i++) {
	    int index = new Random().nextInt(size);
	    swap(o, i, index);
	}
    }

}
