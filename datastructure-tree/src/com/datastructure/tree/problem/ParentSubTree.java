package com.datastructure.tree.problem;

import java.util.ArrayList;
import java.util.List;

import com.datastructure.tree.binary.BinaryTreeNode;
import com.datastructure.tree.util.SampleBinaryTree;

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

    private static void testBinaryTreeTwo() {
	BinaryTreeNode<Character> t1 = new BinaryTreeNode<>('x', null, null);
	t1.left = new BinaryTreeNode<>('a', null, null);
	t1.right = new BinaryTreeNode<>('b', null, null);
	t1.left.right = new BinaryTreeNode<>('c', null, null);

	BinaryTreeNode<Character> t2 = new BinaryTreeNode<>('z', null, null);
	t2.left = new BinaryTreeNode<>('x', null, null);
	t2.left.left = new BinaryTreeNode<>('a', null, null);
	t2.left.right = new BinaryTreeNode<>('b', null, null);
	t2.left.left.right = new BinaryTreeNode<>('c', null, null);
	t2.right = new BinaryTreeNode<>('e', null, null);
	t2.right.right = new BinaryTreeNode<>('k', null, null);

	System.out.println("Binary Tree");
	System.out.println(t1);
	System.out.println(t2);
	boolean result = isSubTree(t1, t2);
	System.out.println("subtree?" + result);
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

}
