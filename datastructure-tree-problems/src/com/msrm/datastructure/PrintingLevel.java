package com.msrm.datastructure;

import java.util.LinkedList;
import java.util.Queue;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;
import com.msrm.datastructure.util.SampleBinaryTree;

public class PrintingLevel {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	root.right.left.left = BinaryTreeUtil.newNode(4);
	root.right.left.right = BinaryTreeUtil.newNode(4);
	printLevelAndNewLine(root);
    }

    public static <T> void printLevelAndNewLine(BinaryTreeNode<T> root) {
	if (root == null)
	    return;
	Queue<BinaryTreeNode<T>> q = new LinkedList<>();
	q.offer(root);
	q.offer(null);
	while (!q.isEmpty()) {
	    root = q.poll();
	    if (root == null) {
		if (q.peek() != null) {
		    q.offer(null);
		    System.out.println();
		}
	    } else {
		System.out.printf("%d\t", root.data);
		if (root.left != null)
		    q.offer(root.left);
		if (root.right != null)
		    q.offer(root.right);
	    }
	}
    }

}
