package com.msrm.datastructure;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;
import com.msrm.datastructure.util.SampleBinaryTree;

public class DiameterOfTree {

	public static void main(String[] args) {
		System.out.println("Solution 1...");
		// Going via root
		BinaryTreeNode<Integer> root1 = SampleBinaryTree.binaryTreeTwo();
		root1.right.right.right = BinaryTreeUtil.newNode(100);
		root1.right.right.right.right = BinaryTreeUtil.newNode(101);
		// root.right.left.left = BinaryTreeUtil.newNode(4);
		// root.right.left.right = BinaryTreeUtil.newNode(4);
		int diameter1 = diameterSol1(root1);
		System.out.println("Diameter of Tree : " + diameter1);

		// Not going via root
		root1 = SampleBinaryTree.binaryTreeThree();
		root1.right.right.right = BinaryTreeUtil.newNode(100);
		root1.right.right.right.right = BinaryTreeUtil.newNode(101);
		diameter1 = diameterSol1(root1);
		System.out.println("Diameter of Tree : " + diameter1);

		System.out.println("\nSolution 2...");
		// Going via root
		BinaryTreeNode<Integer> root2 = SampleBinaryTree.binaryTreeTwo();
		root2.right.right.right = BinaryTreeUtil.newNode(100);
		root2.right.right.right.right = BinaryTreeUtil.newNode(101);
		// root.right.left.left = BinaryTreeUtil.newNode(4);
		// root.right.left.right = BinaryTreeUtil.newNode(4);

		int diameter2 = diameterSol2(root2, new Ref());
		System.out.println("Diameter of Tree : " + diameter2);

		// Not going via root
		root2 = SampleBinaryTree.binaryTreeThree();
		root2.right.right.right = BinaryTreeUtil.newNode(100);
		root2.right.right.right.right = BinaryTreeUtil.newNode(101);
		diameter2 = diameterSol2(root2, new Ref());
		System.out.println("Diameter of Tree : " + diameter2);
	}

	// ====================================================
	// Solution 1: Time O(n^2)
	// ====================================================
	public static <T> int diameterSol1(BinaryTreeNode<T> root) {
		if (root == null)
			return 0;
		int lh = height(root.left);
		int rh = height(root.right);

		int ld = diameterSol1(root.left);
		int rd = diameterSol1(root.right);

		return Math.max(lh + rh + 1, Math.max(ld, rd));
	}

	// The number of nodes on the longest root-to-leaf path
	private static <T> int height(BinaryTreeNode<T> root) {
		if (root == null)
			return 0;
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	// ====================================================
	// Solution 2: Time O(n)
	// ====================================================
	static class Ref {
		int height;
	}

	public static <T> int diameterSol2(BinaryTreeNode<T> root, Ref ref) {
		Ref lh = new Ref(), rh = new Ref();
		int ld, rd;

		if (root == null) {
			ref.height = 0;
			return 0;
		}

		lh.height++;
		rh.height++;

		ld = diameterSol2(root.left, lh);
		rd = diameterSol2(root.right, rh);

		ref.height = 1 + Math.max(lh.height, rh.height);
		return Math.max(lh.height + rh.height + 1, Math.max(ld, rd));
	}

}
