package com.datastructure.tree.problem;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.tree.binary.BinaryTreeNode;
import com.datastructure.tree.binary.CompleteBinaryTreeListImpl;

public class ParentSubTree {

    public static void main(String[] args) {
	testCompleteBinaryTree();
	testBinaryTree();
    }

    private static void testBinaryTree() {
	BinaryTreeNode<Integer> t1 = new BinaryTreeNode<>(8, null, null);
	t1.left = new BinaryTreeNode<>(10, null, null);
	t1.right = new BinaryTreeNode<>(4, null, null);
	t1.left.left = new BinaryTreeNode<>(6, null, null);
	t1.left.right = new BinaryTreeNode<>(9, null, null);
	t1.left.left.left = new BinaryTreeNode<>(4, null, null);
	t1.left.right.left = new BinaryTreeNode<>(7, null, null);
	t1.left.right.right = new BinaryTreeNode<>(5, null, null);

	BinaryTreeNode<Integer> t2 = new BinaryTreeNode<>(8, null, null);
	t2.right = new BinaryTreeNode<>(4, null, null);

	System.out.println(t1);
	System.out.println(t2);
	boolean result = isSubTree(t1, t2);
	System.out.println("subtree?" + result);
    }

    private static void testCompleteBinaryTree() {
	CompleteBinaryTreeListImpl<Integer> t1 = new CompleteBinaryTreeListImpl<>();
	t1.add(84);
	t1.add(24);
	t1.add(12);
	t1.add(83);
	t1.add(3);
	t1.add(5);
	t1.add(1);
	t1.add(7);
	t1.add(9);
	t1.add(10);
	System.out.println(t1.printLevelOrder());

	CompleteBinaryTreeListImpl<Integer> t2 = new CompleteBinaryTreeListImpl<>();
	t2.add(24);
	t2.add(83);
	t2.add(3);
	t2.add(7);
	t2.add(9);
	t2.add(10);
	System.out.println(t2.printLevelOrder());

	boolean result = isSubTree(t1.root, t2.root);
	System.out.println("subtree?" + result);
    }

    public static boolean isSubTree(BinaryTreeNode<Integer> pRoot, BinaryTreeNode<Integer> cRoot) {
	Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
	q.offer(pRoot);
	while (!q.isEmpty()) {
	    BinaryTreeNode<Integer> node = q.poll();
	    if (cRoot.data == node.data) {
		q.clear();
		q.offer(node);
		q.offer(cRoot);
		while (!q.isEmpty()) {
		    BinaryTreeNode<Integer> pNode = q.poll();
		    BinaryTreeNode<Integer> cNode = q.poll();
		    if ((pNode != null && cNode == null) || (pNode == null && cNode != null))
			return false;
		    else {
			if (pNode != null && cNode != null && pNode.data.equals(cNode.data)) {
			    q.offer(pNode.left);
			    q.offer(cNode.left);
			    q.offer(pNode.right);
			    q.offer(cNode.right);
			} else {
			    return pNode == null && cNode == null;
			}
		    }
		}
	    } else {
		if (node.left != null)
		    q.offer(node.left);
		if (node.right != null)
		    q.offer(node.right);
	    }
	}
	return false;
    }
}
