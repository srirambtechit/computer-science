package com.datastructure;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.util.BinaryTreeNode;
import com.datastructure.util.SampleBinaryTree;

public class LevelPrinter {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	root.right.left.left = new BinaryTreeNode<>(4, null, null);
	root.right.left.right = new BinaryTreeNode<>(4, null, null);
	reversePrint(root);
    }

    public static <T> void reversePrint(BinaryTreeNode<T> root) {
	if (root == null)
	    return;
	Queue<BinaryTreeNode<T>> q = new LinkedList<>();
	q.offer(root);
	q.offer(null);
	while (!q.isEmpty()) {
	    root = q.poll();
	    if (root == null) {
		if (q.peek() != null)
		    q.offer(null);
	    } else {
		System.out.printf("%d\t", root.data);
		if (root.right != null)
		    q.offer(root.right);
		if (root.left != null)
		    q.offer(root.left);
	    }
	}
    }

}
