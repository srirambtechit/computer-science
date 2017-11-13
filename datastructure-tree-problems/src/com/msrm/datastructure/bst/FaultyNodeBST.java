package com.msrm.datastructure.bst;

import java.util.ArrayList;
import java.util.List;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;
import com.msrm.datastructure.util.SampleBinaryTree;

public class FaultyNodeBST {

	static class Result {
		boolean result;
		List<BinaryTreeNode<Integer>> bag;

		Result() {
			bag = new ArrayList<>();
		}
	}

	public static List<BinaryTreeNode<Integer>> findFault(BinaryTreeNode<Integer> root) {
		Result res = new Result();
		check(root, Integer.MIN_VALUE, Integer.MAX_VALUE, res);
		return res.bag;
	}

	private static boolean check(BinaryTreeNode<Integer> root, int min, int max, Result res) {
		if (root == null)
			return true;
		if (root.data < min || root.data > max) {
			res.bag.add(root);
			return false;
		}
		return check(root.left, min, root.data, res) && check(root.right, root.data, max, res);
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = SampleBinaryTree.binarySearchTreeOne();
		root = BinaryTreeUtil.newNode(10);
		root.right = BinaryTreeUtil.newNode(12);
		root.right.left = BinaryTreeUtil.newNode(18);
		root.right.right = BinaryTreeUtil.newNode(17);
		root.left = BinaryTreeUtil.newNode(6);
		root.left.left = BinaryTreeUtil.newNode(2);
		List<BinaryTreeNode<Integer>> res = findFault(root);
		System.out.println(res);

		root = BinaryTreeUtil.newNode(10);
		root.left = BinaryTreeUtil.newNode(5);
		root.right = BinaryTreeUtil.newNode(14);
		res = findFault(root);
		System.out.println(res);

		root = SampleBinaryTree.binarySearchTreeOne();
		res = findFault(root);
		System.out.println(res);
	}

}
