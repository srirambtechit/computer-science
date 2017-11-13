package com.msrm.datastructure;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;
import com.msrm.datastructure.util.SampleBinaryTree;

public class AllPathsRootToLeafApproach2<T> {

	private T[] paths;

	@SuppressWarnings("unchecked")
	public void printAllPaths(BinaryTreeNode<T> root) {
		paths = (T[]) new Object[BinaryTreeUtil.height(root) + 1];
		printPaths(root, paths, 0);
	}

	public void printPaths(BinaryTreeNode<T> root, T[] paths, int pathLen) {
		if (root == null)
			return;
		paths[pathLen++] = root.data;

		if (root.left == null && root.right == null) {
			printPath(paths, pathLen);
		} else {
			printPaths(root.left, paths, pathLen);
			printPaths(root.right, paths, pathLen);
		}

	}

	private void printPath(T[] paths, int pathLen) {
		for (int i = 0; i < pathLen; i++) {
			System.out.printf("%d%s", paths[i], i + 1 < pathLen ? " - " : "");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		AllPathsRootToLeafApproach2<Integer> app = new AllPathsRootToLeafApproach2<>();
		app.printAllPaths(SampleBinaryTree.binaryTreeOne());
		app.printAllPaths(SampleBinaryTree.binaryTreeTwo());
		app.printAllPaths(SampleBinaryTree.binaryTreeThree());
	}

}
