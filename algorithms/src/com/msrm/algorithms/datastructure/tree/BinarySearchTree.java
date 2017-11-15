package com.msrm.algorithms.datastructure.tree;

public class BinarySearchTree extends BinaryTree {

    /**
     * <pre>
     * Method used for adding element to BinarySearchTree.
     * if element > root.element, element will be added to right subtree
     * otherwise element will be added to left subtree
     * Duplicate data will be added to left sub tree
     * 
     * &#64;param element
     * </pre>
     */
    public void add(Integer element) {
	if (root == null) {
	    root = new BinaryTreeNode(element, null, null);
	} else {
	    addNode(root, element);
	}
	size++;
    }

    private BinaryTreeNode addNode(BinaryTreeNode node, Integer data) {
	if (node == null) {
	    return new BinaryTreeNode(data, null, null);
	} else if (node.data >= data) {
	    node.left = addNode(node.left, data);
	} else if (node.data < data) {
	    node.right = addNode(node.right, data);
	}
	return node;
    }

    public void delete(Integer data) {
	if (root == null)
	    return;

	root = delete(root, data);
	size--;
    }

    private BinaryTreeNode delete(BinaryTreeNode root, Integer data) {
	if (root == null)
	    return root;

	if (root.data > data) {
	    root.left = delete(root.left, data);
	} else if (root.data < data) {
	    root.right = delete(root.right, data);
	}

	if (root.data.equals(data)) {
	    // case 1: Node to delete is leaf node
	    if (root.left == null && root.right == null) {
		return null;
	    }
	    // case 2a: Node to delete has right subtree
	    else if (root.left == null) {
		return root.right;
	    }
	    // case 2b: Node to delete has left subtree
	    else if (root.right == null) {
		return root.left;
	    }
	    // case 3: Node to delete has both right and left subtree
	    else {
		BinaryTreeNode minNode = findMin(root.right);
		root.data = minNode.data;
		root.right = delete(root.right, minNode.data);
	    }
	}
	return root;
    }

    public static BinaryTreeNode findMin(BinaryTreeNode node) {
	if (node != null && node.left != null)
	    return findMin(node.left);
	return node;
    }

    public static BinaryTreeNode findMax(BinaryTreeNode node) {
	if (node != null && node.right != null)
	    return findMax(node.right);
	return node;
    }

}
