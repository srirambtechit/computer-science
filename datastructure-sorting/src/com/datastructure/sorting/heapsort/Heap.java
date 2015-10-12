package com.datastructure.sorting.heapsort;

import com.datastructure.sorting.util.SortingUtil;
import com.datastructure.sorting.util.Type;

public class Heap {

    public static <T> void sort(Comparable<T>[] a) {
	int n = a.length - 1;
	for (int k = n / 2; k > 0; k--) {
	    sink(a, k, n);
	}

	while (n > 0) {
	    SortingUtil.swap(a, 1, n);
	    sink(a, 1, --n);
	}
    }

    private static <T> void sink(Comparable<T>[] a, int k, int n) {
	while (2 * k <= n) {
	    int j = 2 * k;
	    if (j < n && SortingUtil.less(a[j], a[j + 1]))
		j++;
	    if (!SortingUtil.less(a[k], a[j]))
		break;
	    SortingUtil.swap(a, k, j);
	    k = j;
	}
    }

    public static void main(String[] args) {
	SortingUtil.display(new Integer[] { null, 4, 8, 3, 0, 9, -1, 5 }, Type.Heap);
	SortingUtil.display(new Integer[] { null, 5, 1, 4, 2, 8, 7 }, Type.Heap);
	SortingUtil.display(new Integer[] { null, 6, 5, 3, 1, 8, 7, 2, 4 }, Type.Heap);
	SortingUtil.display(new Integer[] { null, 6, 5, 3, 1, 8, 5, 2, 4 }, Type.Heap);
	SortingUtil.display(new Integer[] { null, 8, -1, 6, 0, 9, 4, 2, -57445, 3254, 245, 21017274 }, Type.Heap);
	SortingUtil.display(new Integer[] {}, Type.Heap);
    }
}
