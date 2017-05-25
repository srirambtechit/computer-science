package com.msrm.algorithms.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SimpleBinaryTree {

    public static TreeNode getTree() {
	Integer[] ints = new Integer[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
	List<Integer> list = new ArrayList<Integer>(Arrays.asList(ints));

	TreeNode root = new TreeNode(1, null, null);
	Stack<TreeNode> stack = new Stack<>();
	stack.push(root);

	while (!list.isEmpty()) {
	    TreeNode node = stack.pop();
	    if (node.left == null) {
		node.left = new TreeNode(list.remove(0), null, null);
		stack.push(node.left);
	    }
	    if (node.right == null) {
		node.right = new TreeNode(list.remove(0), null, null);
		stack.push(node.right);
	    }
	}

	return root;
    }
}
