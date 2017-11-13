package com.msrm.datastructure.bst;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;

public class BSTInsert<T extends Comparable<T>> {

	public BinaryTreeNode<T> root;

	public void insert(T t) {
		if (root == null)
			root = BinaryTreeUtil.newNode(t);
		else
			insert(root, t);
	}

	private BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T t) {
		if (node == null)
			return BinaryTreeUtil.newNode(t);
		if (node.data.compareTo(t) > 0) {
			node.left = insert(node.left, t);
		} else {
			node.right = insert(node.right, t);
		}
		return node;
	}

	public static void main(String[] args) {
		BSTInsert<Integer> bst = new BSTInsert<>();
		bst.insert(10);
		bst.insert(4);
		bst.insert(21);
		bst.insert(53);
		bst.insert(3);
		bst.insert(6);

		System.out.println(bst.root);
	}

}
