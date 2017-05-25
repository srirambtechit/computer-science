package com.msrm.datastructure.bst;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;

public class SortedArrayToBST<T extends Comparable<T>> {

    public boolean isSorted(T[] ts) {
	if (ts == null)
	    return false;
	int len = ts.length;
	if (len < 2) {
	    return true;
	}
	int val = ts[0].compareTo(ts[1]);
	for (int i = 2; i < len; i++) {
	    if (val != ts[i - 1].compareTo(ts[i])) {
		return false;
	    }
	}
	return true;
    }

    public BinaryTreeNode<T> createTree(T[] ts) {
	assert isSorted(ts);
	return constructBST(ts, 0, ts.length - 1);
    }

    private BinaryTreeNode<T> constructBST(T[] ts, int lo, int hi) {
	if (lo > hi)
	    return null;
	int mid = lo + (hi - lo) / 2;
	BinaryTreeNode<T> root = BinaryTreeUtil.newNode(ts[mid]);
	root.left = constructBST(ts, lo, mid - 1);
	root.right = constructBST(ts, mid + 1, hi);
	return root;
    }

    public static void main(String[] args) {
	Integer[] ts = new Integer[] { 100, 200, 300, 400, 500, 600, 700, 800 };
	SortedArrayToBST<Integer> s = new SortedArrayToBST<>();
	System.out.println(s.createTree(ts));
    }

}
