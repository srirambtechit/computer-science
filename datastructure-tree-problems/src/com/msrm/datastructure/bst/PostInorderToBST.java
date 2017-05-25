package com.msrm.datastructure.bst;

import java.util.Arrays;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;

public class PostInorderToBST<T> {

    private int pi;

    public BinaryTreeNode<T> createTree(T[] in, T[] post) {
	if (post.length != in.length)
	    throw new IllegalArgumentException(String.format("Invalid input, in and post order data count mismatch: %d != %d", in.length, post.length));
	pi = post.length - 1;
	return constructTree(in, post, 0, post.length - 1);
    }

    private BinaryTreeNode<T> constructTree(T[] in, T[] post, int lo, int hi) {
	if (lo > hi)
	    return null;
	T t = post[pi--];
	int ri = indexOf(in, t);
	BinaryTreeNode<T> root = BinaryTreeUtil.newNode(t);
	root.right = constructTree(in, post, ri + 1, hi);
	root.left = constructTree(in, post, lo, ri - 1);
	return root;
    }

    public int indexOf(T[] in, T t) {
	return Arrays.binarySearch(in, t);
    }

    public static void main(String[] args) {
	Integer[] in1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	Integer[] post1 = { 1, 3, 2, 5, 4, 7, 9, 8, 6 };
	PostInorderToBST<Integer> o1 = new PostInorderToBST<>();
	BinaryTreeNode<Integer> root1 = o1.createTree(in1, post1);
	System.out.println(root1);

	Integer[] in2 = { 2, 3, 4, 5, 6, 7, 8, 9 };
	Integer[] post2 = { 3, 2, 4, 6, 8, 7, 9, 5 };
	PostInorderToBST<Integer> o2 = new PostInorderToBST<>();
	BinaryTreeNode<Integer> root2 = o2.createTree(in2, post2);
	System.out.println(root2);
    }

}
