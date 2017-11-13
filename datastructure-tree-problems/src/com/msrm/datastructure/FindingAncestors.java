package com.msrm.datastructure;

import java.util.ArrayList;
import java.util.List;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;
import com.msrm.datastructure.util.SampleBinaryTree;

public class FindingAncestors {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
		BinaryTreeNode<Integer> node = root.left.right.left.right;
		List<Integer> ancestors = find(root, node);
		System.out.printf("Ancestor(%d) is %s%n", node.data, ancestors);
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> find(BinaryTreeNode<T> root, BinaryTreeNode<T> node) {
		List<T> ancestors = new ArrayList<>();
		if (root == null || node == null)
			return ancestors;
		T[] t = (T[]) new Object[BinaryTreeUtil.height(root) + 1];
		findAncestors(root, node, ancestors, t, 0);
		return ancestors;
	}

	private static <T> boolean findAncestors(BinaryTreeNode<T> root, BinaryTreeNode<T> node, List<T> ancestors, T[] t, int len) {
		if (root == null || node == null)
			return true;
		t[len++] = root.data;
		if (root == node) {
			for (int i = 0; i < len - 1; i++)
				ancestors.add(t[i]);
		}
		boolean flag = findAncestors(root.left, node, ancestors, t, len);
		if (flag) {
			flag = findAncestors(root.right, node, ancestors, t, len);
		}
		return flag;
	}

}
