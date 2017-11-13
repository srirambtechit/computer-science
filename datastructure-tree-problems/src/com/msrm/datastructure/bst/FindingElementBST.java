package com.msrm.datastructure.bst;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.SampleBinaryTree;

public class FindingElementBST {

	public static <T extends Comparable<T>> boolean find(BinaryTreeNode<T> root, T t) {
		if (root == null || t == null)
			return false;
		boolean flag = false;
		if (root.data.equals(t))
			return true;
		else if (root.data.compareTo(t) > 0) {
			flag = find(root.left, t);
		} else {
			flag = find(root.right, t);
		}
		return flag;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = SampleBinaryTree.binarySearchTreeOne();
		Integer t = null;
		System.out.printf("Searching %d in BST : %b%n", t, find(root, t));
		t = 9;
		System.out.printf("Searching %d in BST : %b%n", t, find(root, t));
		t = 145;
		System.out.printf("Searching %d in BST : %b%n", t, find(root, t));
	}
}
