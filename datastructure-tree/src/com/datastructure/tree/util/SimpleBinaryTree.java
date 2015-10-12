package com.datastructure.tree.util;

import com.datastructure.tree.binary.BinaryTreeNode;
import com.datastructure.tree.binary.CompleteBinaryTreeListImpl;

public class SimpleBinaryTree {

    /**
     * <pre>
     * 			8
     * 		10		4
     * 	    6 	     9
     * 	  4 	   7   5
     * </pre>
     * 
     * @return will returns root of tree
     */
    public static BinaryTreeNode<Integer> getSimpleTree() {
	BinaryTreeNode<Integer> root = new BinaryTreeNode<>(8, null, null);
	root.left = new BinaryTreeNode<>(10, null, null);
	root.right = new BinaryTreeNode<>(4, null, null);
	root.left.left = new BinaryTreeNode<>(6, null, null);
	root.left.right = new BinaryTreeNode<>(9, null, null);
	root.left.left.left = new BinaryTreeNode<>(4, null, null);
	root.left.right.left = new BinaryTreeNode<>(7, null, null);
	root.left.right.right = new BinaryTreeNode<>(5, null, null);
	return root;
    }

    public static <T> BinaryTreeNode<T> getSimpleCompleteTree(T[] nodes) {
	CompleteBinaryTreeListImpl<T> tree = new CompleteBinaryTreeListImpl<>();
	for (T t : nodes) {
	    tree.add(t);
	}
	return tree.root;
    }

}
