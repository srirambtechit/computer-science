package com.datastructure;

import com.datastructure.util.BinaryTreeNode;
import com.datastructure.util.BinaryTreeUtil;
import com.datastructure.util.SampleBinaryTree;

public class FindingNode {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	root.right.left.left = BinaryTreeUtil.newNode(11);
	root.right.left.right = BinaryTreeUtil.newNode(12);
	ResultWrapper<Integer> rw = new ResultWrapper<>();
	rw.element = 19;
	findNode(root, rw);
	if (rw.node != null)
	    System.out.printf("Node data %d\t %s%n", rw.node.data, rw.node);
	else
	    System.out.println("Node not found");
    }

    static class ResultWrapper<T> {
	T element;
	BinaryTreeNode<T> node;
    }

    private static <T> BinaryTreeNode<T> findNode(BinaryTreeNode<T> root, ResultWrapper<T> rw) {
	if (root == null)
	    return null;
	if (root.data.equals(rw.element))
	    rw.node = root;
	findNode(root.left, rw);
	findNode(root.right, rw);
	return null;
    }

}
