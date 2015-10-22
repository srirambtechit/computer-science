package com.datastructure.tree.binary;

import java.util.Stack;

public class BinaryTreeTraversalDemo {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = newNode(1);
	root.left = newNode(2);
	root.right = newNode(3);
	root.left.left = newNode(4);
	root.left.right = newNode(5);
	root.right.left = newNode(6);
	root.right.right = newNode(7);

	root.left.right.left = newNode(8);
	root.left.right.left.left = newNode(9);
	root.left.right.left.right = newNode(10);

	System.out.println(root);

	System.out.println("\nPost order traversal - iterative method");
	postOrderIterative(root);

	System.out.println("\nPost order traversal - recursive method");
	postOrderRecursive(root);

    }

    public static <T> void postOrderRecursive(BinaryTreeNode<T> root) {
	if (root == null)
	    return;
	postOrderRecursive(root.left);
	postOrderRecursive(root.right);
	System.out.printf("%d\t", root.data);
    }

    public static <T> void postOrderIterative(BinaryTreeNode<T> root) {
	if (root == null)
	    return;

	Stack<BinaryTreeNode<T>> s = new Stack<>();
	do {
	    while (root != null) {
		if (root.right != null)
		    s.push(root.right);
		s.push(root);
		root = root.left;
	    }
	    root = s.pop();
	    if (!s.isEmpty() && root.right != null && root.right == s.peek()) {
		s.pop();
		s.push(root);
		root = root.right;
	    } else {
		System.out.printf("%d\t", root.data);
		root = null;
	    }
	} while (!s.isEmpty());
	System.out.println();
    }

    private static BinaryTreeNode<Integer> newNode(int i) {
	return new BinaryTreeNode<Integer>(i, null, null);
    }

}
