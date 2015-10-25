package com.datastructure.util;

public class BinaryTreeUtil {
    public static <T> int height(BinaryTreeNode<T> root) {
	if (root == null)
	    return -1;
	return Math.max(height(root.left), height(root.right)) + 1;
    }
}
