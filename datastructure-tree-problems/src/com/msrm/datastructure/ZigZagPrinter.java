package com.msrm.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;
import com.msrm.datastructure.util.SampleBinaryTree;

public class ZigZagPrinter {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	root.right.left.left = BinaryTreeUtil.newNode(4);
	root.right.left.right = BinaryTreeUtil.newNode(4);
	print(root);
    }

    public static <T> void print(BinaryTreeNode<T> root) {
	if (root == null)
	    return;
	Queue<BinaryTreeNode<T>> q = new LinkedList<>();
	Stack<BinaryTreeNode<T>> s = new Stack<>();
	int dir = 0;
	q.offer(root);
	while (!q.isEmpty()) {
	    int size = q.size();
	    for (int i = 0; i < size; i++) {
		root = q.poll();
		if (dir == 1) {
		    s.push(root);
		} else {
		    System.out.printf("%d\t", root.data);
		}
		if (root.left != null)
		    q.offer(root.left);
		if (root.right != null)
		    q.offer(root.right);
	    }
	    if (dir == 1) {
		while (!s.isEmpty()) {
		    System.out.printf("%d\t", s.pop().data);
		}
		dir = 0;
	    } else
		dir = 1;
	}
    }

}
