package com.msrm.datastructure;

import java.util.ArrayList;
import java.util.List;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;
import com.msrm.datastructure.util.SampleBinaryTree;

/**
 * Check given tree S is sub tree of tree T
 * 
 * @author sriram
 *
 */
public class ParentSubTree {

    public static void main(String[] args) {
	testCompleteBinaryTree();
	System.out.println();
	testBinaryTree();
	System.out.println();
	testBinaryTreeTwo();
    }

    /**
     * Solution to the problem
     * 
     * @param t
     * @param s
     * @return
     */
    public static <T> boolean isSubTree(BinaryTreeNode<T> t, BinaryTreeNode<T> s) {
	List<T> inT = new ArrayList<>();
	List<T> preT = new ArrayList<>();
	List<T> inS = new ArrayList<>();
	List<T> preS = new ArrayList<>();
	inorder(t, inT);
	preorder(t, preT);
	inorder(s, inS);
	preorder(s, preS);
	return inT.containsAll(inS) && preT.containsAll(preS);
    }

    private static <T> void preorder(BinaryTreeNode<T> t, List<T> bag) {
	if (t == null)
	    return;
	bag.add(t.data);
	if (t.left != null)
	    preorder(t.left, bag);
	if (t.right != null)
	    preorder(t.right, bag);
    }

    private static <T> void inorder(BinaryTreeNode<T> t, List<T> bag) {
	if (t == null)
	    return;
	if (t.left != null)
	    inorder(t.left, bag);
	bag.add(t.data);
	if (t.right != null)
	    inorder(t.right, bag);
    }

    /**
     * Sample data to test the problem
     */
    private static void testBinaryTreeTwo() {
	BinaryTreeNode<Character> t1 = BinaryTreeUtil.newNode('x');
	t1.left = BinaryTreeUtil.newNode('a');
	t1.right = BinaryTreeUtil.newNode('b');
	t1.left.right = BinaryTreeUtil.newNode('c');

	BinaryTreeNode<Character> t2 = BinaryTreeUtil.newNode('z');
	t2.left = BinaryTreeUtil.newNode('x');
	t2.left.left = BinaryTreeUtil.newNode('a');
	t2.left.right = BinaryTreeUtil.newNode('b');
	t2.left.left.right = BinaryTreeUtil.newNode('c');
	t2.right = BinaryTreeUtil.newNode('e');
	t2.right.right = BinaryTreeUtil.newNode('k');

	System.out.println("Binary Tree");
	System.out.println(t1);
	System.out.println(t2);
	boolean result = isSubTree(t1, t2);
	System.out.println("subtree?" + result);
    }

    private static void testBinaryTree() {
	BinaryTreeNode<Integer> t1 = BinaryTreeUtil.newNode(8);
	t1.left = BinaryTreeUtil.newNode(10);
	t1.right = BinaryTreeUtil.newNode(4);
	t1.left.left = BinaryTreeUtil.newNode(6);
	t1.left.right = BinaryTreeUtil.newNode(9);
	t1.left.left.left = BinaryTreeUtil.newNode(4);
	t1.left.right.left = BinaryTreeUtil.newNode(7);
	t1.left.right.right = BinaryTreeUtil.newNode(5);

	BinaryTreeNode<Integer> t2 = BinaryTreeUtil.newNode(8);
	t2.right = BinaryTreeUtil.newNode(4);

	System.out.println("Binary Tree");
	System.out.println(t1);
	System.out.println(t2);
	boolean result = isSubTree(t1, t2);
	System.out.println("subtree?" + result);
    }

    private static void testCompleteBinaryTree() {
	BinaryTreeNode<Integer> rootOne = SampleBinaryTree.getCompleteTree(new Integer[] { 84, 24, 12, 83, 3, 5, 1, 7, 9, 10 });
	BinaryTreeNode<Integer> rootTwo = SampleBinaryTree.getCompleteTree(new Integer[] { 24, 83, 3, 7, 9, 10 });
	System.out.println("Complete Binary Tree");
	System.out.println("Tree 1 : " + rootOne);
	System.out.println("Tree 2 : " + rootTwo);
	boolean result = isSubTree(rootOne, rootTwo);
	System.out.println("subtree?" + result);
    }

}
