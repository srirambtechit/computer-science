package com.msrm.datastructure.bst;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.SampleBinaryTree;

public class BSTDelete {

	public static <T extends Comparable<T>> BinaryTreeNode<T> delete(BinaryTreeNode<T> root, T t) {
		if (root == null || t == null)
			return null;
		if (root.data.equals(t)) {
			// case 1: root has no child
			if (root.left == null && root.right == null) {
				root = null;
			}
			// case 2: root has 1 child
			else if (root.right == null) {
				root = root.left;
			} else if (root.left == null) {
				root = root.right;
			}
			// case 3: root has 2 child
			else {
				BinaryTreeNode<T> min = findMin(root.right);
				root.data = min.data;
				root.right = delete(root.right, min.data);
			}
		} else if (root.data.compareTo(t) > 0) {
			root.left = delete(root.left, t);
		} else {
			root.right = delete(root.right, t);
		}
		return root;
	}

	private static <T> BinaryTreeNode<T> findMin(BinaryTreeNode<T> root) {
		if (root == null)
			return null;
		while (root != null && root.left != null) {
			root = root.left;
		}
		return root;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = SampleBinaryTree.binarySearchTreeOne();
		System.out.println(root);

		delete(root, 7);
		System.out.println(root);

		delete(root, 6);
		System.out.println(root);

		delete(root, 14);
		System.out.println(root);
	}

}
