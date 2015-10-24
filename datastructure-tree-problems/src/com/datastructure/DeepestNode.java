package com.datastructure;

import com.datastructure.util.BinaryTreeNode;
import com.datastructure.util.SampleBinaryTree;

public class DeepestNode<T> {

    int level;
    BinaryTreeNode<T> deepNode;

    public BinaryTreeNode<T> deep(BinaryTreeNode<T> root) {
	find(root, 0);
	return deepNode;
    }

    private BinaryTreeNode<T> find(BinaryTreeNode<T> root, int level) {
	if (root == null)
	    return root;
	find(root.left, ++level);
	if (this.level < level) {
	    this.level = level;
	    deepNode = root;
	}
	find(root.right, ++level);
	return root;
    }

    public static void main(String[] args) {
	DeepestNode<Integer> dn = new DeepestNode<>();
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	root.right.right.right = SampleBinaryTree.newNode(100);
	root.right.right.right.right = SampleBinaryTree.newNode(101);
	root.right.right.right.right.right = SampleBinaryTree.newNode(102);
	System.out.println("Deepest node : " + dn.deep(root));
    }

}
