package com.datastructure;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.util.BinaryTreeNode;
import com.datastructure.util.BinaryTreeUtil;
import com.datastructure.util.SampleBinaryTree;

public class LevelPrinter {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	root.right.left.left = BinaryTreeUtil.newNode(4);
	root.right.left.right = BinaryTreeUtil.newNode(4);
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
