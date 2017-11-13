package com.msrm.datastructure;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.SampleBinaryTree;

public class FindingMinMaxNode {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeOne();
		ResultWrapper<Integer> rw = new ResultWrapper<>();
		findMin(root, rw);
		System.out.printf("Minimum value in tree is %d%n", rw.min.data);

		findMax(root, rw);
		System.out.printf("Maximum value in tree is %d%n", rw.max.data);
	}

	public static <T extends Comparable<T>> void findMin(BinaryTreeNode<T> root, ResultWrapper<T> rw) {
		if (root == null)
			return;
		if (rw.min == null) {
			rw.min = root;
		} else {
			if (rw.min.data.compareTo(root.data) > 0)
				rw.min = root;
		}
		findMin(root.left, rw);
		findMin(root.right, rw);
	}

	public static <T extends Comparable<T>> void findMax(BinaryTreeNode<T> root, ResultWrapper<T> rw) {
		if (root == null)
			return;
		if (rw.max == null) {
			rw.max = root;
		} else {
			if (rw.max.data.compareTo(root.data) < 0)
				rw.max = root;
		}
		findMax(root.left, rw);
		findMax(root.right, rw);
	}

	static class ResultWrapper<T extends Comparable<T>> {
		BinaryTreeNode<T> min;
		BinaryTreeNode<T> max;
	}

}
