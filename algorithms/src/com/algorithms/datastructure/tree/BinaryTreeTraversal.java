package com.algorithms.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * Tree is a non-linear data structure. so, it will not be in any order.
 * Generally, linear structure will have consistent path to traverse or iterate
 * whereas Tree will not.
 * 
 * There are two methods for traversing/iterating Tree structured data.
 * a) Breadth First Traversal/Level order traversal
 * b) Depth First Traversal
 * 	  i) preorder (root left right)
 * 	 ii) inorder  (left root right)
 *      iii) postorder(left right root)
 * All theses traversal can be achieved either by recursive or iterative approach.
 * </pre>
 * 
 * @author sriram
 *
 */
public class BinaryTreeTraversal {

    public static void levelOrder(BinaryTree tree) {
	if (tree == null)
	    return;
	System.out.println("LEVEL-Order");

	Queue<BinaryTreeNode> queue = new LinkedList<>();
	queue.add(tree.root);
	while (!queue.isEmpty()) {
	    BinaryTreeNode node = queue.poll();
	    if (node != null) {
		System.out.printf(" %d ", node.data);
		if (node.left != null)
		    queue.add(node.left);
		if (node.right != null)
		    queue.add(node.right);
	    }
	}
	System.out.println();
    }

    public static void preorder(BinaryTree tree) {
	if (tree == null)
	    return;
	System.out.println("PRE-Order");
	preorder(tree.root);
	System.out.println();
    }

    private static void preorder(BinaryTreeNode node) {
	if (node == null)
	    return;
	System.out.printf(" %d ", node.data);
	preorder(node.left);
	preorder(node.right);
    }

    public static void inorder(BinaryTree tree) {
	if (tree == null)
	    return;
	System.out.println("IN-Order");
	inorder(tree.root);
	System.out.println();
    }

    private static void inorder(BinaryTreeNode node) {
	if (node == null)
	    return;
	inorder(node.left);
	System.out.printf(" %d ", node.data);
	inorder(node.right);
    }

    public static void postorder(BinaryTree tree) {
	if (tree == null)
	    return;
	System.out.println("POST-Order");
	postorder(tree.root);
	System.out.println();
    }

    private static void postorder(BinaryTreeNode node) {
	if (node == null)
	    return;
	postorder(node.left);
	postorder(node.right);
	System.out.printf(" %d ", node.data);
    }

}
