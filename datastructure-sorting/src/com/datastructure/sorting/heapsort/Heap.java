package com.datastructure.sorting.heapsort;

import com.datastructure.sorting.util.SortingUtil;
import com.datastructure.sorting.util.Type;

public class Heap {

    public static <T> void sort(Comparable<T>[] a) {
	int n = a.length;
	for (int k = n / 2; k >= 1; k--) {
	    sink(a, k, n);
	}
	while (n > 1) {
	    SortingUtil.swap(a, 1, n);
	    sink(a, 1, --n);
	}
    }

    /**
     * Level of N nodes in tree
     * Ex: L = 1 when n = 1
     * L = 2 when n = 2,3
     * L = 3 when n = 4, 5, 6, 7
     * L = 4 when n = 8, 9, 10, 11, 12, 13, 14, 15
     * L = k when n = 2*k, 2*k+1, 2*k+2, ..., 2^k-1
     * 
     * @param n
     * @return
     */
    private static int levelOf(int n) {
	int level = 0;
	while (n > 0) {
	    level++;
	    n = n >> 1;
	}
	return level;
    }

    private static <T> void swim(Comparable<T>[] a, int k, int n) {
	while (k > 1 && SortingUtil.less(a[k / 2], a[k])) {
	    SortingUtil.swap(a, k / 2, k);
	    k = k / 2;
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
	SortingUtil.display(new Integer[] { -1, 5, 1, 4, 2, 8, 7 }, Type.Heap);
	// SortingUtil.display(new Integer[] { 6, 5, 3, 1, 8, 7, 2, 4 },
	// Type.Heap);
	// SortingUtil.display(new Integer[] { 8, -1, 6, 0, 9, 4, 2, -57445,
	// 3254, 245, 21017274 }, Type.Heap);
	// SortingUtil.display(new Integer[] {}, Type.Heap);
    }
}
