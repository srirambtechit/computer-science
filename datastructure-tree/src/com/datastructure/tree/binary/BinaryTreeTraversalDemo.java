package com.datastructure.tree.binary;

import java.util.Stack;

import com.datastructure.tree.util.SampleBinaryTree;

public class BinaryTreeTraversalDemo {

    public static void main(String[] args) {
	allTraversals(SampleBinaryTree.binaryTreeOne());
	allTraversals(SampleBinaryTree.binaryTreeTwo());
	allTraversals(SampleBinaryTree.leftSkewedTree());
    }

    private static <T> void allTraversals(BinaryTreeNode<T> root) {
	System.out.println("Tree: " + root);

	System.out.println("\nPost order traversal - iterative method");
	postOrderIterative(root);

	System.out.println("\nPost order traversal - recursive method");
	postOrderRecursive(root);

	System.out.println("\n\nPre order traversal - iterative method");
	preOrderIterative(root);

	System.out.println("\n\nPre order traversal - recursive method");
	preOrderRecursive(root);

	System.out.println("\n\nIn order traversal - iterative method");
	inOrderIterative(root);

	System.out.println("\n\nIn order traversal - recursive method");
	inOrderRecursive(root);
	System.out.println("\n----------------------------------------\n");
    }

    public static <T> void inOrderRecursive(BinaryTreeNode<T> root) {
	if (root == null)
	    return;
	inOrderRecursive(root.left);
	System.out.printf("%d\t", root.data);
	inOrderRecursive(root.right);
    }

    public static <T> void inOrderIterative(BinaryTreeNode<T> root) {
	if (root == null)
	    return;
	Stack<BinaryTreeNode<T>> s = new Stack<>();

	while (true) {
	    while (root != null) {
		s.push(root);
		root = root.left;
	    }
	    if (s.isEmpty())
		break;
	    root = s.pop();
	    System.out.printf("%d\t", root.data);
	    if (root.right == null)
		root = null;
	    else
		root = root.right;
	}
    }

    public static <T> void preOrderRecursive(BinaryTreeNode<T> root) {
	if (root == null)
	    return;
	System.out.printf("%d\t", root.data);
	preOrderIterative(root.left);
	preOrderIterative(root.right);
    }

    public static <T> void preOrderIterative(BinaryTreeNode<T> root) {
	if (root == null)
	    return;
	Stack<BinaryTreeNode<T>> s = new Stack<>();
	s.push(root);
	while (!s.isEmpty()) {
	    root = s.pop();
	    System.out.printf("%d\t", root.data);
	    if (root.right != null)
		s.push(root.right);
	    if (root.left != null)
		s.push(root.left);
	}
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

}
