package com.msrm.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;
import com.msrm.datastructure.util.SampleBinaryTree;

public class CountNodeWithOneChild {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	root.right.left.left = BinaryTreeUtil.newNode(14);
	int count = countOneChildNode(root);
	System.out.printf("No of nodes who has exactly one child in a tree is %d%n", count);
	List<BinaryTreeNode<Integer>> nodes = getOneChildNode(root);
	for (BinaryTreeNode<Integer> node : nodes) {
	    System.out.println(node.data);
	}
    }

    public static <T> int countOneChildNode(BinaryTreeNode<T> root) {
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
		if ((root.left != null && root.right == null) || (root.left == null && root.right != null))
		    count++;
	    }
	}
	return count;
    }

    public static <T> List<BinaryTreeNode<T>> getOneChildNode(BinaryTreeNode<T> root) {
	List<BinaryTreeNode<T>> bag = new ArrayList<>();
	if (root == null)
	    return bag;
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
		if ((root.left != null && root.right == null) || (root.left == null && root.right != null))
		    bag.add(root);
	    }
	}
	return bag;
    }
}
