package com.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.datastructure.util.BinaryTreeNode;
import com.datastructure.util.SampleBinaryTree;

public class PrintingMaximumSumInLevel {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	root.right.left.left = new BinaryTreeNode<>(14, null, null);
	root.right.left.right = new BinaryTreeNode<>(4, null, null);
	int count = printMaxSum(root);
	System.out.printf("Maximum sum of level in tree is %d%n", count);
    }

    public static int printMaxSum(BinaryTreeNode<Integer> root) {
	List<Integer> sumList = new ArrayList<>();
	calculateLevelByLevel(root, sumList);
	System.out.println("list :  " + sumList);
	return Collections.max(sumList);
    }

    private static void calculateLevelByLevel(BinaryTreeNode<Integer> root, List<Integer> sumList) {
	if (root == null)
	    return;
	Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
	q.offer(root);
	q.offer(null);
	sumList.add(root.data);
	int sum = 0;
	while (!q.isEmpty()) {
	    root = q.poll();
	    if (root == null) {
		if (q.peek() != null) {
		    q.offer(null);
		    sumList.add(sum);
		    sum = 0;
		}
	    } else {
		if (root.left != null) {
		    q.offer(root.left);
		    sum += root.left.data;
		}
		if (root.right != null) {
		    q.offer(root.right);
		    sum += root.right.data;
		}
	    }
	}
    }

}
