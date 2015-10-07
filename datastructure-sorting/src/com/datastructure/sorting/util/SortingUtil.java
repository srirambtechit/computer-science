package com.datastructure.sorting.util;

import java.util.Arrays;
import java.util.Random;

import com.datastructure.sorting.bubblesort.Bubble;
import com.datastructure.sorting.insertionsort.Insertion;
import com.datastructure.sorting.mergesort.Merge;
import com.datastructure.sorting.quicksort.Quick;
import com.datastructure.sorting.selectionsort.Selection;

public class SortingUtil {

    public static <T> void display(Comparable<T>[] dataSet, Type type) {
	System.out.println(type + " Sorting");
	System.out.println(Arrays.toString(dataSet));
	doSort(dataSet, type);
	System.out.println(Arrays.toString(dataSet));
	System.out.println();
    }

    private static <T> void doSort(Comparable<T>[] dataSet, Type type) {
	switch (type) {
	case Bubble:
	    Bubble.sort(dataSet);
	    break;
	case Bubble_Optimized:
	    Bubble.bubbleSortOptimized(dataSet);
	    break;
	case Insertion:
	    Insertion.sort(dataSet);
	    break;
	case Merge:
	    Merge.sort(dataSet);
	    break;
	case Selection:
	    Selection.sort(dataSet);
	    break;
	case Quick:
	    Quick.sort(dataSet);
	    break;
	}
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> boolean greater(Comparable c1, Comparable c2) {
	return c1.compareTo(c2) == 1;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static boolean greater(Comparable[] o, int i, int j) {
	return o[i].compareTo(o[j]) == 1;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> boolean less(Comparable c1, Comparable c2) {
	return c1.compareTo(c2) == -1;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static boolean less(Comparable[] o, int i, int j) {
	return o[i].compareTo(o[j]) == -1;
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

    public static void main(String[] args) {
	System.out.println(less(new Integer[] { 1, 0 }, 0, 1)); // f
	System.out.println(less(new Integer[] { 1, -1 }, 0, 1)); // f
	System.out.println(less(new Integer[] { -1, 0 }, 0, 1)); // t
	System.out.println(less(new Integer[] { -1, 1 }, 0, 1)); // t
	System.out.println(less(new Integer[] { 0, -1 }, 0, 1)); // f
	System.out.println(less(new Integer[] { 0, 1 }, 0, 1)); // t

	System.out.println();

	System.out.println(greater(new Integer[] { 1, 0 }, 0, 1)); // t
	System.out.println(greater(new Integer[] { 1, -1 }, 0, 1)); // t
	System.out.println(greater(new Integer[] { -1, 0 }, 0, 1)); // f
	System.out.println(greater(new Integer[] { -1, 1 }, 0, 1)); // f
	System.out.println(greater(new Integer[] { 0, -1 }, 0, 1)); // t
	System.out.println(greater(new Integer[] { 0, 1 }, 0, 1)); // f
    }

}
