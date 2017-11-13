package com.msrm.datastructure;

import java.util.LinkedList;
import java.util.Queue;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;
import com.msrm.datastructure.util.SampleBinaryTree;

public class DepthOfNode {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
		root.left.right.left.left.left = BinaryTreeUtil.newNode(14);
		root.left.right.left.left.left.right = BinaryTreeUtil.newNode(4);
		BinaryTreeNode<Integer> node = root.left.right.left.right;
		if (node != null) {
			int count = depth(root, node);
			System.out.printf("depth of %d in tree is %d%n", node.data, count);
		}
	}

	public static <T> int depth(BinaryTreeNode<T> root, BinaryTreeNode<T> node) {
		if (root == null || node == null)
			return -1;
		int d = 0;
		Queue<BinaryTreeNode<T>> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			root = q.poll();
			if (root == null) {
				if (root != q.peek()) {
					q.offer(null);
					d++;
				}
			} else {
				if (root == node)
					return d;
				if (root.left != null)
					q.offer(root.left);
				if (root.right != null)
					q.offer(root.right);
			}
		}
		return d;
	}

}
