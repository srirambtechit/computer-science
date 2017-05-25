package com.msrm.algorithms.datastructure.tree.test;

import org.junit.Before;
import org.junit.Test;

import com.msrm.algorithms.datastructure.tree.BinarySearchTree;
import com.msrm.algorithms.datastructure.tree.BinaryTreeTraversal;

public class BinaryTreeTraversalTest {
    BinarySearchTree emptyTree;
    BinarySearchTree treeWithData;

    @Before
    public void setUp() throws Exception {
	emptyTree = new BinarySearchTree();
	treeWithData = createTree();
    }

    private BinarySearchTree createTree() {
	treeWithData = new BinarySearchTree();
	Integer[] data = { 10, 5, 3, 2, 4, 8, 6, 7, 9, 14, 12, 13, 16, 15 };
	for (Integer integer : data) {
	    treeWithData.add(integer);
	}
	return treeWithData;
    }

    @Test
    public void testLevelOrder() {
	System.out.println("\nTree: ");
	BinaryTreeTraversal.levelOrder(treeWithData);
    }

    @Test
    public void testPreoder() {
	System.out.println("\nTree: ");
	BinaryTreeTraversal.preorder(treeWithData);
    }

    @Test
    public void testInoder() {
	System.out.println("\nTree: ");
	BinaryTreeTraversal.inorder(treeWithData);
    }

    @Test
    public void testPostoder() {
	System.out.println("\nTree: ");
	BinaryTreeTraversal.postorder(treeWithData);
    }
}
