package com.msrm.datastructure;

import java.util.LinkedList;
import java.util.Queue;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;
import com.msrm.datastructure.util.SampleBinaryTree;

public class NodeLevel {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
		root.right.left.left = BinaryTreeUtil.newNode(14);
		root.right.left.right = BinaryTreeUtil.newNode(24);
		BinaryTreeNode<Integer> nodeOne = root.left.left;
		BinaryTreeNode<Integer> nodeTwo = root.right.left;
		if (nodeOne != null && nodeTwo != null) {
			if (sameLevel(root, nodeOne, nodeTwo)) {
				System.out.printf("%d, %d are at same level", nodeOne.data, nodeTwo.data);
			} else {
				System.out.printf("%d, %d are not at same level", nodeOne.data, nodeTwo.data);
			}
		}
	}

	public static <T> boolean sameLevel(BinaryTreeNode<T> root, BinaryTreeNode<T> nodeOne, BinaryTreeNode<T> nodeTwo) {
		if (root == null || nodeOne == null || nodeTwo == null)
			return false;
		Queue<BinaryTreeNode<T>> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			root = q.poll();
			if (root == null) {
				if (q.peek() != null)
					q.offer(null);
			} else {
				// any one of node matched, arrived to same level
				if (root == nodeOne || root == nodeTwo) {
					while (!q.isEmpty()) {
						BinaryTreeNode<T> node = q.poll();
						if (node == nodeOne || node == nodeTwo)
							return true;
						// different level nodes will hold null marker
						// in Q between two levels, Ex: 3, 5 are level one 4, 6,
						// 8 are level two, finding 3, 4 are same level? q[...3,
						// 5, null, 4, 6, 8 null...]
						if (node == null)
							return false;
					}
				}
				if (root.left != null)
					q.offer(root.left);
				if (root.right != null)
					q.offer(root.right);
			}
		}
		return false;
	}

}
