package com.datastructure.sorting.util;

public class SortingUtil {

    public static void swap(Object[] o, int i, int j) {
	Object t = o[i];
	o[i] = o[j];
	o[j] = t;
    }

}
