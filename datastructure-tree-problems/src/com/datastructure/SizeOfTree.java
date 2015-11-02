package com.datastructure;

import com.datastructure.util.BinaryTreeNode;
import com.datastructure.util.BinaryTreeUtil;
import com.datastructure.util.SampleBinaryTree;

public class SizeOfTree {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	root.left.left.left = BinaryTreeUtil.newNode(3);
	int count = countNodes(root);
	System.out.printf("No nodes in a tree is %d%n", count);
    }

    public static <T> int countNodes(BinaryTreeNode<T> root) {
	if (root == null)
	    return 0;
	return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
