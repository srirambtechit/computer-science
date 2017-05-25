package com.msrm.datastructure.util;

public class BinaryTreeUtil {

    public static <T> int height(BinaryTreeNode<T> root) {
	if (root == null)
	    return -1;
	return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static <T> BinaryTreeNode<T> newNode(T t) {
	return new BinaryTreeNode<>(t, null, null);
    }

}
