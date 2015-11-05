package com.datastructure.bst;

import com.datastructure.util.BinaryTreeNode;
import com.datastructure.util.SampleBinaryTree;

public class FindKthElementBST<T> {

    private class Result {
	int indexK;
	int indexCounter;
	T element;
    }

    public T elementAt(BinaryTreeNode<T> root, int k) {
	Result res = new Result();
	res.indexK = k;
	findElement(root, res);
	return res.element;
    }

    private void findElement(BinaryTreeNode<T> root, Result res) {
	if (root == null)
	    return;
	findElement(root.left, res);
	if (res.indexCounter == res.indexK) {
	    res.element = root.data;
	}
	res.indexCounter++;
	findElement(root.right, res);
	return;
    }

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binarySearchTreeOne();
	System.out.println(root);

	FindKthElementBST<Integer> f = new FindKthElementBST<>();
	for (int i = 0; i < 10; i++) {
	    System.out.printf("Find at index %d : %d%n", i, f.elementAt(root, i));
	}
    }

}
