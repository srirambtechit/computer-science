package com.datastructure;

import com.datastructure.util.BinaryTreeNode;
import com.datastructure.util.SampleBinaryTree;

public class HeightOfTree {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	root.left.right.left.left.left = new BinaryTreeNode<>(1, null, null);
	int count = height(root);
	System.out.printf("No of Full nodes in a tree is %d%n", count);
    }

    /**
     * Height of tree is no of edges in the longest path of the Tree
     * 
     * @param root
     * @return
     */
    public static <T> int height(BinaryTreeNode<T> root) {
	if (root == null)
	    return -1;
	int leftHeight = height(root.left);
	int rightHeight = height(root.right);
	return Math.max(leftHeight, rightHeight) + 1;
    }

}
