package com.datastructure.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.datastructure.LowestCommonAncestor;
import com.datastructure.util.BinaryTreeNode;
import com.datastructure.util.BinaryTreeUtil;
import com.datastructure.util.SampleBinaryTree;

public class LowestCommonAncestorTest {

    BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();

    @Test
    public void testFindLCACase1() {
	BinaryTreeNode<Integer> nodeOne = root.left.left;
	BinaryTreeNode<Integer> nodeTwo = root.left;
	BinaryTreeNode<Integer> res = LowestCommonAncestor.findLCA(root, nodeOne, nodeTwo);
	System.out.println(res);
	assertEquals("anscestor equals", new Integer(2), res != null ? res.data : null);
    }

    @Test
    public void testFindCase1() {
	BinaryTreeNode<Integer> nodeOne = root.left.left;
	BinaryTreeNode<Integer> nodeTwo = root.left;
	assertEquals("anscestor equals", new Integer(2), LowestCommonAncestor.find(root, nodeOne, nodeTwo));
    }

    @Test
    public void testFindLCACase2() {
	BinaryTreeNode<Integer> nodeOne = root.left.right.left.right;
	BinaryTreeNode<Integer> nodeTwo = root.right.left;
	BinaryTreeNode<Integer> res = LowestCommonAncestor.findLCA(root, nodeOne, nodeTwo);
	assertEquals("anscestor equals", new Integer(1), res != null ? res.data : null);
    }

    @Test
    public void testFindCase2() {
	BinaryTreeNode<Integer> nodeOne = root.left.right.left.right;
	BinaryTreeNode<Integer> nodeTwo = root.right.left;
	assertEquals("anscestor equals", new Integer(1), LowestCommonAncestor.find(root, nodeOne, nodeTwo));
    }

    @Test
    public void testFindLCACase3() {
	BinaryTreeNode<Integer> nodeOne = root.left;
	BinaryTreeNode<Integer> nodeTwo = root.left.left;
	BinaryTreeNode<Integer> res = LowestCommonAncestor.findLCA(root, nodeOne, nodeTwo);
	assertEquals("anscestor equals", new Integer(2), res != null ? res.data : null);
    }

    @Test
    public void testFindCase3() {
	BinaryTreeNode<Integer> nodeOne = root.left;
	BinaryTreeNode<Integer> nodeTwo = root.left.left;
	assertEquals("anscestor equals", new Integer(2), LowestCommonAncestor.find(root, nodeOne, nodeTwo));
    }

    @Test
    public void testFindLCACase4() {
	BinaryTreeNode<Integer> nodeOne = root;
	BinaryTreeNode<Integer> nodeTwo = root.left.left;
	BinaryTreeNode<Integer> res = LowestCommonAncestor.findLCA(root, nodeOne, nodeTwo);
	assertEquals("anscestor equals", new Integer(1), res != null ? res.data : null);
    }

    @Test
    public void testFindCase4() {
	BinaryTreeNode<Integer> nodeOne = root;
	BinaryTreeNode<Integer> nodeTwo = root.left.left;
	assertEquals("anscestor equals", new Integer(1), LowestCommonAncestor.find(root, nodeOne, nodeTwo));
    }

    @Test
    public void testFindLCACase5() {
	BinaryTreeNode<Integer> nodeOne = BinaryTreeUtil.newNode(41);
	BinaryTreeNode<Integer> nodeTwo = root.left.left;
	BinaryTreeNode<Integer> res = LowestCommonAncestor.findLCA(root, nodeOne, nodeTwo);
	assertEquals("anscestor equals", null, res != null ? res.data : null);
    }

    @Test
    public void testFindCase5() {
	BinaryTreeNode<Integer> nodeOne = BinaryTreeUtil.newNode(41);
	BinaryTreeNode<Integer> nodeTwo = root.left.left;
	assertEquals("anscestor equals", null, LowestCommonAncestor.find(root, nodeOne, nodeTwo));
    }

}
