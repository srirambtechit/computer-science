package com.datastructure.bst;

import com.datastructure.util.BinaryTreeNode;
import com.datastructure.util.BinaryTreeUtil;
import com.datastructure.util.SampleBinaryTree;

public class BSTCheck {

    public static boolean isBST(BinaryTreeNode<Integer> root) {
	if (root == null)
	    return false;
	return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST(BinaryTreeNode<Integer> root, Integer min, Integer max) {
	if (root == null)
	    return true;
	if ((root.data < min || root.data > max))
	    return false;
	return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binarySearchTreeOne();
	root = BinaryTreeUtil.newNode(10);
	root.left = BinaryTreeUtil.newNode(5);
	root.left.left = BinaryTreeUtil.newNode(3);
	root.left.left.left = BinaryTreeUtil.newNode(4);
	System.out.println(root);
	System.out.println("BST : " + isBST(root));

	root = BinaryTreeUtil.newNode(10);
	root.left = BinaryTreeUtil.newNode(5);
	root.right = BinaryTreeUtil.newNode(14);
	System.out.println(root);
	System.out.println("BST : " + isBST(root));

	root = SampleBinaryTree.binarySearchTreeOne();
	System.out.println(root);
	System.out.println("BST : " + isBST(root));
    }

}
