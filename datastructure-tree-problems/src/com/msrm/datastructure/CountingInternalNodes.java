package com.msrm.datastructure;

import java.util.LinkedList;
import java.util.Queue;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;
import com.msrm.datastructure.util.SampleBinaryTree;

/**
 * Internal node – a node with at least one child.
 * 
 * @author sriram
 *
 */
public class CountingInternalNodes {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	root.right.left.left = BinaryTreeUtil.newNode(4);
	root.right.left.right = BinaryTreeUtil.newNode(4);
	int count = countInternalNode(root);
	System.out.printf("No of Internal nodes in a tree is %d%n", count);
    }

    public static <T> int countInternalNode(BinaryTreeNode<T> root) {
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
		// count all nodes except leaf nodes
		if (!(root.right == null && root.left == null))
		    count++;
	    }
	}
	return count;
    }

}
