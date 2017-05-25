package com.msrm.datastructure;

import java.util.ArrayList;
import java.util.List;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;
import com.msrm.datastructure.util.SampleBinaryTree;

public class FindingPathOfGivenSum {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	int[] sum = { 7, 25, 8, 26, 10, 11 };
	for (int s : sum) {
	    List<Integer> path = findPath(root, s);
	    System.out.printf("sum of nodes in a path %3d  is %s%n", s, path);
	}
    }

    public static List<Integer> findPath(BinaryTreeNode<Integer> root, int sum) {
	List<Integer> path = new ArrayList<>();
	// Create array with size of height of tree + 1 and
	// add 1 to hold size of array
	Integer[] t = new Integer[BinaryTreeUtil.height(root) + 1 + 1];
	findPath(root, sum, t, 0);
	int len = t[t.length - 1];
	if (len != -1) {
	    for (int i = 0; i < len; i++) {
		path.add(t[i]);
	    }
	}
	return path;
    }

    private static boolean findPath(BinaryTreeNode<Integer> root, int sum, Integer[] t, int len) {
	if (root == null)
	    return true;
	t[len++] = root.data;
	if (root.left == null && root.right == null) {
	    int s = 0, i = 0;
	    for (; i < len; i++) {
		s += t[i];
		// for debug, uncomment
		// System.out.printf("%d\t", t[i]);
	    }
	    // System.out.printf(" - %d%n", s);
	    t[t.length - 1] = -1;
	    if (s == sum) {
		t[t.length - 1] = len;
		return false;
	    }
	}
	boolean flag = findPath(root.left, sum, t, len);
	if (flag) {
	    flag = findPath(root.right, sum, t, len);
	}
	return flag;
    }

}
