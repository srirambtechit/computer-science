package com.msrm.datastructure;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeTraversal;
import com.msrm.datastructure.util.SampleBinaryTree;

public class MirrorTree {

	/**
	 * Post order traversal needed as the nodes should be processed at end of
	 * the traversal of the tree, then just swap the left and right pointers of
	 * the node to form the mirror tree
	 * 
	 * @param root
	 * @return
	 */
	public static <T> BinaryTreeNode<T> mirror(BinaryTreeNode<T> root) {
		if (root == null)
			return root;

		mirror(root.left);
		mirror(root.right);

		// Just swap the pointers to construct the mirror nodes
		BinaryTreeNode<T> temp = root.left;
		root.left = root.right;
		root.right = temp;

		return root;
	}

	public static void main(String[] args) {
		BinaryTreeTraversal.levelOrderIterative(SampleBinaryTree.binaryTreeOne());
		System.out.println();
		BinaryTreeTraversal.levelOrderIterative(mirror(SampleBinaryTree.binaryTreeOne()));
	}
}
