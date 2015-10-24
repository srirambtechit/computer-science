package com.datastructure;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.util.BinaryTreeNode;
import com.datastructure.util.SampleBinaryTree;

public class CountingFullNode {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	root.right.left.left = new BinaryTreeNode<>(4, null, null);
	root.right.left.right = new BinaryTreeNode<>(4, null, null);
	int count = countFullNode(root);
	System.out.printf("No of Full nodes in a tree is %d%n", count);
    }

    /**
     * In BinaryTree, a full node will have 2 children
     * 
     * @param root
     * @return
     */
    public static <T> int countFullNode(BinaryTreeNode<T> root) {
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
		if (root.left != null && root.right != null)
		    count++;
	    }
	}
	return count;
    }

}
