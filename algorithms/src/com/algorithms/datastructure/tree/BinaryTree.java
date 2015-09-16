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
public class BinaryTree {

    public BinaryTreeNode root;

    protected int size;

    public int size() {
	return size;
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
