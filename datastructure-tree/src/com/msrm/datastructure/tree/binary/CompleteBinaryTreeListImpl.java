package com.msrm.datastructure.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Link based complete binary tree implementation
 * 
 * @author sriram
 *
 */
public class CompleteBinaryTreeListImpl<Item> {

    public BinaryTreeNode<Item> root;

    /**
     * Add element to form complete binary tree
     * 
     * @param e
     */
    public void add(Item e) {
	BinaryTreeNode<Item> newNode = new BinaryTreeNode<>(e, null, null);
	if (root == null) {
	    root = newNode;
	    return;
	}

	Queue<BinaryTreeNode<Item>> q = new LinkedList<>();
	q.offer(root);
	while (true) {
	    BinaryTreeNode<Item> node = q.poll();
	    if (node.left == null) {
		node.left = newNode;
		break;
	    } else if (node.right == null) {
		node.right = newNode;
		break;
	    }
	    if (node.left != null) {
		q.offer(node.left);
	    }
	    if (node.right != null) {
		q.offer(node.right);
	    }
	}
    }

    public String printLevelOrder() {
	if (root == null)
	    return "[]";
	StringBuffer sb = new StringBuffer();
	Queue<BinaryTreeNode<Item>> q = new LinkedList<>();
	q.offer(root);
	sb.append("[");
	while (!q.isEmpty()) {
	    BinaryTreeNode<Item> node = q.poll();
	    sb.append(node.data);
	    if (node.left != null) {
		q.offer(node.left);
	    }
	    if (node.right != null) {
		q.offer(node.right);
	    }
	    if (!q.isEmpty()) {
		sb.append(", ");
	    }
	}
	sb.append("]");
	return sb.toString();
    }

    public String toString() {
	if (root == null)
	    return "[]";
	return "[" + root.toString() + "]";
    }
}
