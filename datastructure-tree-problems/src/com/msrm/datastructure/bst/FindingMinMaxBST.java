package com.msrm.datastructure.bst;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.SampleBinaryTree;

public class FindingMinMaxBST {

	public static <T extends Comparable<T>> T findMin(BinaryTreeNode<T> root) {
		if (root == null)
			return null;
		BinaryTreeNode<T> node = root;
		while (node != null && node.left != null) {
			node = node.left;
		}
		return node.data;
	}

	public static <T extends Comparable<T>> T findMax(BinaryTreeNode<T> root) {
		if (root == null)
			return null;
		BinaryTreeNode<T> node = root;
		while (node != null && node.right != null) {
			node = node.right;
		}
		return node.data;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = SampleBinaryTree.binarySearchTreeOne();
		Integer min = findMin(root);
		System.out.println("Min : " + min);

		Integer max = findMax(root);
		System.out.println("Max : " + max);
	}

}
