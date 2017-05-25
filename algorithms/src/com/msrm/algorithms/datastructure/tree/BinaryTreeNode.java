package com.msrm.algorithms.datastructure.tree;

public class BinaryTreeNode {
    public Integer data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(Integer data, BinaryTreeNode left, BinaryTreeNode right) {
	super();
	this.data = data;
	this.left = left;
	this.right = right;
    }

    @Override
    public String toString() {
	return "BinaryTreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
    }

}
