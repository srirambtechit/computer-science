package com.msrm.datastructure.bst;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;
import com.msrm.datastructure.util.SampleBinaryTree;

public class BSTCheck {

    // Time O(n); Space O(1);
    static class SolutionOne<T extends Comparable<T>> {

	public static <T extends Comparable<T>> boolean isBST(BinaryTreeNode<T> node) {
	    SolutionOne<T> instance = new SolutionOne<>();
	    return instance.isBSTUtil(node);
	}

	private BinaryTreeNode<T> prev;

	/**
	 * 1. Performing inorder traversal
	 * 2. Comparing previous and current node data
	 * 
	 * @param curr
	 * @return
	 */
	private boolean isBSTUtil(BinaryTreeNode<T> curr) {
	    if (curr != null) {
		if (!isBSTUtil(curr.left))
		    return false;
		if (prev != null && curr.data.compareTo(prev.data) <= 0)
		    return false;
		prev = curr;
		return isBSTUtil(curr.right);
	    }
	    return true;
	}
    }

    // Time O(n); Space O(n) stack uses additional space
    static class SolutionTwo {
	public static boolean isBST(BinaryTreeNode<Integer> root) {
	    if (root == null)
		return false;
	    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isBST(BinaryTreeNode<Integer> root, Integer min, Integer max) {
	    if (root == null)
		return true;
	    if (root.data < min || root.data > max)
		return false;
	    return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
	}
    }

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binarySearchTreeOne();
	root = BinaryTreeUtil.newNode(10);
	root.left = BinaryTreeUtil.newNode(5);
	root.left.left = BinaryTreeUtil.newNode(3);
	root.left.left.left = BinaryTreeUtil.newNode(4);
	System.out.println(root);
	System.out.println("Solution 2 : " + SolutionTwo.isBST(root) + "; solution 1 : " + SolutionOne.isBST(root));

	root = BinaryTreeUtil.newNode(10);
	root.left = BinaryTreeUtil.newNode(5);
	root.right = BinaryTreeUtil.newNode(14);
	System.out.println(root);
	System.out.println("Solution 2 : " + SolutionTwo.isBST(root) + "; solution 1 : " + SolutionOne.isBST(root));

	root = SampleBinaryTree.binarySearchTreeOne();
	System.out.println(root);
	System.out.println("Solution 2 : " + SolutionTwo.isBST(root) + "; solution 1 : " + SolutionOne.isBST(root));

    }
}
