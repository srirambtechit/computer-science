package com.msrm.algorithms.datastructure.tree.test;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import com.msrm.algorithms.datastructure.tree.BinarySearchTree;
import com.msrm.algorithms.datastructure.tree.BinaryTree;
import com.msrm.algorithms.datastructure.tree.BinaryTreeNode;

public class BinarySearchTreeTest {

    BinarySearchTree emptyTree;
    BinarySearchTree treeWithData;

    @Before
    public void setUp() throws Exception {
	emptyTree = new BinarySearchTree();
	treeWithData = createTree();
	System.out.println(treeWithData);
	System.out.println();
    }

    private BinarySearchTree createTree() {
	treeWithData = new BinarySearchTree();
	Integer[] data = { 10, 5, 3, 2, 4, 8, 6, 7, 9, 14, 12, 13, 16, 15 };
	for (Integer integer : data) {
	    treeWithData.add(integer);
	}
	return treeWithData;
    }

    private BinaryTreeNode getNode(int data) {
	Stack<BinaryTreeNode> stack = new Stack<>();
	if (treeWithData != null) {
	    stack.push(treeWithData.root);
	    while (!stack.isEmpty()) {
		BinaryTreeNode node = stack.pop();
		if (node.data == data) {
		    return node;
		}
		if (node.left != null) {
		    stack.push(node.left);
		}
		if (node.right != null) {
		    stack.push(node.right);
		}
	    }
	}
	return null;
    }

    @Test
    public void testCopyTree() {
	BinaryTree tree = new BinaryTree();
	tree.root = new BinaryTreeNode(1, null, null);
	tree.root.left = new BinaryTreeNode(2, null, null);
	tree.root.right = new BinaryTreeNode(3, null, null);
	BinaryTree copy = tree.copyTree();
	assertEquals("tree Copy", tree.toString(), copy.toString());
    }

    @Test
    public void testDepthOfNode_1() {
	BinaryTree tree = new BinaryTree();
	tree.root = new BinaryTreeNode(1, null, null);
	tree.root.left = new BinaryTreeNode(2, null, null);
	tree.root.right = new BinaryTreeNode(3, null, null);
	tree.root.left.left = new BinaryTreeNode(4, null, null);
	tree.root.left.right = new BinaryTreeNode(5, null, null);
	tree.root.left.right.left = new BinaryTreeNode(6, null, null);
	tree.root.left.right.right = new BinaryTreeNode(7, null, null);
	System.out.println("My Tree");
	System.out.println(tree);

	System.out.println(tree.root.data + "; My Tree depth: " + tree.depth());
	System.out.println(tree.root.left.left.data + "; My Tree depth: " + tree.depthOf(tree.root.left.left));
	System.out.println(tree.root.left.data + "; My Tree depth: " + tree.depthOf(tree.root.left));
	System.out.println(tree.root.left.right.data + "; My Tree depth: " + tree.depthOf(tree.root.left.right));
	System.out.println(tree.root.left.right.left.data + "; My Tree depth: " + tree.depthOf(tree.root.left.right.left));
    }

    @Test
    public void testDepthOfNode() {
	BinaryTreeNode node = getNode(14);
	System.out.println("Depth of node : " + node);
	int depth = treeWithData.depthOf(node);
	assertEquals("Depth of node", 3, depth);
    }

    @Test
    public void testDepthOfTree_emptyTree() {
	int depth = emptyTree.depth();
	assertEquals("Depth of emptyTree", 0, depth);
    }

    @Test
    public void testDepthOfTree() {
	int depth = treeWithData.depth();
	assertEquals("Depth of tree", 5, depth);
    }

    @Test
    public void testHeightOfTree_NormalTree() {
	System.out.println("Height of tree");
	assertEquals("Height of tree", 4, treeWithData.height());
    }

    @Test
    public void testHeightOfTree_emptyTree() {
	System.out.println("Height of tree - empty tree");
	BinarySearchTree bst = new BinarySearchTree();
	assertEquals("Height of tree - empty tree", -1, bst.height());
    }

    @Test
    public void testHeightOfTree_rootNode() {
	System.out.println("Height of tree - root node alone");
	BinarySearchTree bst = new BinarySearchTree();
	bst.add(3);
	assertEquals("Height of tree - root node alone", 0, bst.height());
    }

    @Test
    public void testDelete_treeWithData_7() {
	System.out.println("Deleting element(10) from BST");
	int size = treeWithData.size();
	System.out.println("After deletion : " + treeWithData);
	treeWithData.delete(10);
	System.out.println("After deletion : " + treeWithData);
	assertEquals("delete", size - 1, treeWithData.size());
    }

    @Test
    public void testDelete_treeWithData_6() {
	System.out.println("Deleting element(15) from BST");
	BinarySearchTree bst = new BinarySearchTree();
	bst.add(10);
	bst.add(5);
	bst.add(15);
	bst.add(4);
	bst.add(17);
	bst.add(16);
	bst.add(18);
	bst.add(13);

	System.out.println("Before deletion : " + bst);

	int size = bst.size();
	bst.delete(15);

	System.out.println("After deletion : " + bst);

	assertEquals("delete", size - 1, bst.size());
    }

    @Test
    public void testDelete_treeWithData_5() {
	System.out.println("Deleting element(5) from BST");

	BinarySearchTree bst = new BinarySearchTree();
	bst.add(10);
	bst.add(5);
	bst.add(15);
	bst.add(4);

	System.out.println("Before deletion : " + bst);

	int size = bst.size();
	bst.delete(5);

	System.out.println("After deletion : " + bst);

	assertEquals("delete", size - 1, bst.size());
    }

    /**
     * deleting leaf node
     */
    @Test
    public void testDelete_treeWithData_4() {
	System.out.println("Deleting element(4) from BST");

	BinarySearchTree bst = new BinarySearchTree();
	bst.add(10);
	bst.add(5);
	bst.add(15);
	bst.add(4);

	System.out.println("Before deletion : " + bst);

	int size = bst.size();
	bst.delete(4);

	System.out.println("After deletion : " + bst);

	assertEquals("delete", size - 1, bst.size());
    }

    @Test
    public void testDelete_treeWithData_3() {
	System.out.println("Deleting element(15) from BST");

	BinarySearchTree bst = new BinarySearchTree();
	bst.add(10);
	bst.add(5);
	bst.add(15);

	System.out.println("Before deletion : " + bst);
	int size = bst.size();
	bst.delete(15);
	System.out.println("After deletion : " + bst);
	assertEquals("delete", size - 1, bst.size());
    }

    @Test
    public void testDelete_treeWithData_2() {
	System.out.println("Deleting element(5) from BST");

	BinarySearchTree bst = new BinarySearchTree();
	bst.add(10);
	bst.add(5);

	System.out.println("Before deletion : " + bst);
	int size = bst.size();
	bst.delete(5);
	System.out.println("After deletion : " + bst);
	assertEquals("delete", size - 1, bst.size());
    }

    @Test
    public void testDelete_treeWithData_1() {
	System.out.println("Deleting element(10) from BST");

	BinarySearchTree bst = new BinarySearchTree();
	bst.add(10);

	System.out.println("Before deletion : " + bst);
	int size = bst.size();
	bst.delete(10);
	System.out.println("After deletion : " + bst);
	assertEquals("delete", size - 1, bst.size());
    }

    @Test
    public void testDelete_emptyTree() {
	System.out.println("Deleting element from Empty BST");
	emptyTree.delete(3);
	assertEquals("delete", 0, emptyTree.size());
    }

    @Test
    public void testFindMax() {
	System.out.println("Finding Max value in BST");
	BinaryTreeNode treeNode = BinarySearchTree.findMax(treeWithData.root);
	if (treeNode != null) {
	    System.out.println("Max : " + treeNode.data);
	    assertEquals("findMax", Integer.valueOf(16), treeNode.data);
	}
    }

    @Test
    public void testFindMin() {
	System.out.println("Finding Min value in BST");
	BinaryTreeNode treeNode = BinarySearchTree.findMin(treeWithData.root);
	if (treeNode != null) {
	    System.out.println("Min : " + treeNode.data);
	    assertEquals("findMin", Integer.valueOf(2), treeNode.data);
	}
    }

    @Test
    public void testEmptyTreePrint() {
	System.out.println("Printing empty tree");
	System.out.println(emptyTree);
	assertEquals("Empty tree size?", 0, emptyTree.size());
    }

    @Test
    public void testAdd() {
	System.out.println("Adding elements to BST");
	emptyTree.add(5);
	emptyTree.add(3);
	emptyTree.add(2);
	emptyTree.add(4);
	emptyTree.add(8);
	emptyTree.add(9);
	System.out.println(emptyTree);
	assertEquals("tree size?", 6, emptyTree.size());
    }

}
