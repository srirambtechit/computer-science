package com.msrm.datastructure;

import java.util.LinkedList;
import java.util.Queue;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.SampleBinaryTree;

/**
 * Leaf – a node with no children. External node – a node with no children
 * 
 * @author sriram
 *
 */
public class CountingLeafNode {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
		int count = countLeafNode(root);
		System.out.printf("No of Leaf nodes in a tree is %d%n", count);
	}

	public static <T> int countLeafNode(BinaryTreeNode<T> root) {
		if (root == null)
			return 0;
		int count = 0;
		Queue<BinaryTreeNode<T>> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			root = q.poll();
			if (root == null) {
				if (q.peek() != null)
					q.offer(null);
			} else {
				if (root.left != null)
					q.offer(root.left);
				if (root.right != null)
					q.offer(root.right);
				if (root.left == null && root.right == null)
					count++;
			}
		}
		return count;
	}

}
