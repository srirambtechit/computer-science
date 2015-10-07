package com.datastructure.tree.binary;

/**
 * BinaryTreeNode representation
 * 
 * @author sriram
 *
 */
class BinaryTreeNode<Item> {
    Item data;
    BinaryTreeNode<Item> left, right;

    BinaryTreeNode(Item data, BinaryTreeNode<Item> left, BinaryTreeNode<Item> right) {
	this.data = data;
	this.left = left;
	this.right = right;
    }

    private void printTree(StringBuilder b) {
	b.append(data);
	if (this.left != null) {
	    b.append(", ");
	    left.printTree(b);
	}
	if (this.right != null) {
	    b.append(", ");
	    right.printTree(b);
	}
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	printTree(sb);
	return sb.toString();
    }
}