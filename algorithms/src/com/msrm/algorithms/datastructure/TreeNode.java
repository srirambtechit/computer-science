package com.msrm.algorithms.datastructure;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    Integer data;

    public TreeNode(Integer data, TreeNode left, TreeNode right) {
	this.data = data;
	this.left = left;
	this.right = right;
    }

    public void print() {
	System.out.print(this.data + "\t");
	if (left != null) {
	    left.print();
	}
	if (right != null) {
	    right.print();
	}
    }

}
