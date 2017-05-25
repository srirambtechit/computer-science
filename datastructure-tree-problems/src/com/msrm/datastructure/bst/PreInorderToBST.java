package com.msrm.datastructure.bst;

import java.util.Arrays;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;

public class PreInorderToBST<T> {

    private int pi;

    public BinaryTreeNode<T> createTree(T[] in, T[] pre) {
	if (in == null || pre == null || in.length != pre.length)
	    throw new IllegalArgumentException("Invalid Inorder & Preorder sequence : " + in.length + "!=" + pre.length);
	// Initializing preorder Index marker
	pi = 0;
	return constructTree(in, pre, 0, pre.length - 1);
    }

    private BinaryTreeNode<T> constructTree(T[] in, T[] pre, int lo, int hi) {
	if (lo > hi)
	    return null;
	T t = pre[pi++];
	int ri = indexOf(in, t);
	if (ri < 0)
	    throw new IllegalArgumentException("Invalid data");
	BinaryTreeNode<T> root = BinaryTreeUtil.newNode(t);
	root.left = constructTree(in, pre, lo, ri - 1);
	root.right = constructTree(in, pre, ri + 1, hi);
	return root;
    }

    // Used binarySearch here. To search an element in sorted array of
    // data is O(log n)
    private int indexOf(T[] in, T t) {
	// for (int i = 0; i < in.length; i++) {
	// if (t.equals(in[i]))
	// return i;
	// }
	// return -1;
	return Arrays.binarySearch(in, t);
    }

    public static void main(String[] args) {
	Integer[] in = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	Integer[] pre = { 6, 4, 2, 1, 3, 5, 8, 7, 9 };
	PreInorderToBST<Integer> o = new PreInorderToBST<>();
	BinaryTreeNode<Integer> root = o.createTree(in, pre);
	System.out.println(root);
    }

}
