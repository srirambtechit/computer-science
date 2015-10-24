package com.datastructure.tree.binary;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.datastructure.tree.util.SampleBinaryTree;

/**
 * <pre>
 * Tree Traversal:-
 * Basic idea, 
 * 	- Breath First Search(BFS)
 *  	- Depth First Search (DFS)
 *  Level order will be BFS
 *  In, Pre and Post order traversals will be DFS
 * 
 * </pre>
 * 
 * @author sriram
 *
 */
public class BinaryTreeTraversalDemo {

    public static void main(String[] args) {
	allTraversals(SampleBinaryTree.binaryTreeOne());
	allTraversals(SampleBinaryTree.binaryTreeTwo());
	allTraversals(SampleBinaryTree.leftSkewedTree());
    }

    /**
     * <pre>
     * Another alg: 
     * Time O(n); Space O(n); Iterative approach
     * This problem can be solved by two stacks s1, s2 as well
     * - have direction flag
     * - s1 for left to right
     * - s2 for right to left
     * - loop till s1 or s2 queue is not empty
     * </pre>
     * 
     * @param root
     */
    public static <T> void levelOrderZigZag(BinaryTreeNode<T> root) {
	if (root == null)
	    return;
	Queue<BinaryTreeNode<T>> q = new LinkedList<>();
	Stack<BinaryTreeNode<T>> s = new Stack<>();
	int dir = 0;
	q.offer(root);
	while (!q.isEmpty()) {
	    int size = q.size();
	    for (int i = 0; i < size; i++) {
		root = q.poll();
		if (dir == 1) {
		    s.push(root);
		} else {
		    System.out.printf("%d\t", root.data);
		}
		if (root.left != null)
		    q.offer(root.left);
		if (root.right != null)
		    q.offer(root.right);
	    }
	    if (dir == 1) {
		while (!s.isEmpty()) {
		    System.out.printf("%d\t", s.pop().data);
		}
		dir = 0;
	    } else
		dir = 1;
	}
    }

    public static <T> void levelOrderNullMarker(BinaryTreeNode<T> root) {
	if (root == null)
	    return;
	Queue<BinaryTreeNode<T>> q = new LinkedList<>();
	q.offer(root);
	q.offer(null);
	while (!q.isEmpty()) {
	    root = q.poll();
	    // when root is null, one level traversed in tree
	    if (root == null) {
		if (q.peek() != null)
		    q.offer(null);
	    } else {
		System.out.printf("%d\t", root.data);
		if (root.left != null)
		    q.offer(root.left);
		if (root.right != null)
		    q.offer(root.right);
	    }
	}
    }

    /**
     * Time - O(n^2)
     * 
     * @param root
     */
    public static <T> void levelOrderRecursive(BinaryTreeNode<T> root) {
	for (int l = 1; l <= height(root); l++) {
	    printLevel(root, l);
	}
    }

    private static <T> void printLevel(BinaryTreeNode<T> root, int level) {
	if (root == null)
	    return;
	if (level == 1)
	    System.out.printf("%d\t", root.data);
	else if (level > 1) {
	    printLevel(root.left, level - 1);
	    printLevel(root.right, level - 1);
	}
    }

    /**
     * Counts number of nodes in longest path from given node to leaf node
     * 
     * @param root
     * @return
     */
    private static <T> int height(BinaryTreeNode<T> root) {
	if (root == null)
	    return 0;
	int lh = height(root.left);
	int rh = height(root.right);
	return Math.max(lh, rh) + 1;
    }

    /**
     * Time - O(n)
     * 
     * @param root
     */
    public static <T> void levelOrderIterative(BinaryTreeNode<T> root) {
	if (root == null)
	    return;
	Queue<BinaryTreeNode<T>> q = new LinkedList<>();
	q.offer(root);
	while (!q.isEmpty()) {
	    root = q.poll();
	    System.out.printf("%d\t", root.data);
	    if (root.left != null)
		q.offer(root.left);
	    if (root.right != null)
		q.offer(root.right);
	}
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

	System.out.println("\n\nLevel order traversal - iterative method");
	levelOrderIterative(root);

	System.out.println("\n\nLevel order traversal - recursive method");
	levelOrderRecursive(root);

	System.out.println("\n\nZigZag (or) Spiral traversal - iterative method");
	levelOrderZigZag(root);
	System.out.println("\n----------------------------------------\n");
    }

}
