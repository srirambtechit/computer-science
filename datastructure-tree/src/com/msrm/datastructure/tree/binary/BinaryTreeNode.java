package com.msrm.datastructure.tree.binary;

/**
 * BinaryTreeNode representation
 * 
 * @author sriram
 *
 */
public class BinaryTreeNode<Item> {
	public Item data;
	public BinaryTreeNode<Item> left, right;

	public BinaryTreeNode(Item data, BinaryTreeNode<Item> left, BinaryTreeNode<Item> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	private void printPreOrderTree(StringBuilder b) {
		b.append(data);
		if (this.left != null) {
			b.append(", ");
			left.printPreOrderTree(b);
		}
		if (this.right != null) {
			b.append(", ");
			right.printPreOrderTree(b);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		printPreOrderTree(sb);
		return sb.toString();
	}
}