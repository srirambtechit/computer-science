package com.algorithms.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * TREE TERMINOLOGY: 
 *     - The depth of a node is the number of edges from the root to the node.
 *     - The height of a node is the number of edges from the node to the deepest leaf.
 *     - The height of a tree is a height of the root.
 *     - A full binary tree.is a binary tree in which each node has exactly zero or two children.
 *     - A complete binary tree is a binary tree, which is completely filled, with the possible 
 *     exception of the bottom level, which is filled from left to right.
 *     
 * ADVANTAGES OF TREES:
 * Trees are so useful and frequently used, because they have some very serious advantages:
 * 
 *     Trees reflect structural relationships in the data
 *     Trees are used to represent hierarchies
 *     Trees provide an efficient insertion and searching
 *     Trees are very flexible data, allowing to move subtrees around with minumum effort
 * </pre>
 * 
 * @author sriram
 *
 */
public class BinarySearchTree {

    public BinaryTreeNode root;

    private int size;

    public int size() {
	return size;
    }

    /**
     * <pre>
     * Method used for adding element to BinarySearchTree.
     * if element > root.element, element will be added to right subtree
     * otherwise element will be added to left subtree
     * Duplicate data will be added to left sub tree
     * 
     * @param element
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

    /**
     * <pre>
     * The height of a node is the number of edges from the node to the deepest leaf.
     * The height of a tree is a height of the root.
     * Ex:     
     * if a no tree, then Height(root) is -1
     * if a tree has only one node which is root, then Height(root) is 0
     * if a tree has root and one left child, then Height(root) is 1
     * 
     * </pre>
     * 
     * @return
     */
    public int height() {
	return height(root);
    }

    private int height(BinaryTreeNode node) {
	if (node == null)
	    return -1;
	int leftHeight = height(node.left);
	int rightHeight = height(node.right);
	return Math.max(leftHeight, rightHeight) + 1;
    }

    public String toString() {

	class PrintTree {

	    private List<Integer> dataBag = new ArrayList<>();

	    public void traverseTree(BinaryTreeNode root) {
		if (root == null) {
		    return;
		}
		dataBag.add(root.data);
		traverseTree(root.left);
		traverseTree(root.right);
	    }

	    public List<Integer> getData() {
		return dataBag;
	    }
	}

	PrintTree printer = new PrintTree();
	printer.traverseTree(root);

	return printer.getData().toString();
    }
}
