package com.datastructure;

import com.datastructure.util.BinaryTreeNode;
import com.datastructure.util.BinaryTreeUtil;
import com.datastructure.util.SampleBinaryTree;

public class DiameterOfTree {

    public static void main(String[] args) {
	// Going via root
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	root.right.right.right = BinaryTreeUtil.newNode(100);
	root.right.right.right.right = BinaryTreeUtil.newNode(101);
	// root.right.left.left = BinaryTreeUtil.newNode(4);
	// root.right.left.right = BinaryTreeUtil.newNode(4);
	int diameter = diameter(root);
	System.out.println("Diameter of Tree : " + diameter);

	// Not going via root
	root = SampleBinaryTree.binaryTreeThree();
	root.right.right.right = BinaryTreeUtil.newNode(100);
	root.right.right.right.right = BinaryTreeUtil.newNode(101);
	diameter = diameter(root);
	System.out.println("Diameter of Tree : " + diameter);
    }

    // ====================================================
    // Solution 1: Time O(n^2)
    // ====================================================
    public static <T> int diameter(BinaryTreeNode<T> root) {
	if (root == null)
	    return 0;
	int lh = height(root.left);
	int rh = height(root.right);

	int ld = diameter(root.left);
	int rd = diameter(root.right);

	return Math.max(lh + rh + 1, Math.max(ld, rd));
    }

    // The number of nodes on the longest root-to-leaf path
    private static <T> int height(BinaryTreeNode<T> root) {
	if (root == null)
	    return 0;
	return Math.max(height(root.left), height(root.right)) + 1;
    }

}
