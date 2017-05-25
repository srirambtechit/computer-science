package com.msrm.datastructure.util;

import com.msrm.datastructure.bst.BSTInsert;

public class SampleBinaryTree {

    /**
     * <pre>
     * 			8
     * 		10		2
     * 	    6 	     9
     * 	  4 	   7   5
     * </pre>
     * 
     * @return will returns root of tree
     */
    public static BinaryTreeNode<Integer> binaryTreeOne() {
	BinaryTreeNode<Integer> root = newNodeUtil(8);
	root.left = newNodeUtil(10);
	root.right = newNodeUtil(2);
	root.left.left = newNodeUtil(6);
	root.left.right = newNodeUtil(9);
	root.left.left.left = newNodeUtil(4);
	root.left.right.left = newNodeUtil(7);
	root.left.right.right = newNodeUtil(5);
	return root;
    }

    /**
     * <pre>
     * 		       1
     * 		2	    3
     * 	    4      5	 6     7
     * 		8     
     *       9   10
     * </pre>
     * 
     * @return
     */
    public static BinaryTreeNode<Integer> binaryTreeTwo() {
	BinaryTreeNode<Integer> root = newNodeUtil(1);
	root.left = newNodeUtil(2);
	root.right = newNodeUtil(3);
	root.left.left = newNodeUtil(4);
	root.left.right = newNodeUtil(5);
	root.right.left = newNodeUtil(6);
	root.right.right = newNodeUtil(7);
	root.left.right.left = newNodeUtil(8);
	root.left.right.left.left = newNodeUtil(9);
	root.left.right.left.right = newNodeUtil(10);
	return root;
    }

    /**
     * <pre>
     *                          1
     *                         /\
     *                        /  \
     *                       /    \
     *                      2      3
     *                     /\       \
     *                    /  \       \
     *                   4    5       6
     *                  /\     \
     *                 /  \     \
     *                7    8     9
     *                    /     / \
     *                   10    11  12 
     *                   /\         \
     *                 13  14        15
     * </pre>
     * 
     * @return
     */
    public static BinaryTreeNode<Integer> binaryTreeThree() {
	BinaryTreeNode<Integer> root = newNodeUtil(1);
	root.left = newNodeUtil(2);
	root.right = newNodeUtil(3);
	root.right.right = newNodeUtil(6);
	root.left.left = newNodeUtil(4);
	root.left.right = newNodeUtil(5);
	root.left.left.left = newNodeUtil(7);
	root.left.left.right = newNodeUtil(8);
	root.left.right.right = newNodeUtil(9);
	root.left.left.right.left = newNodeUtil(10);
	root.left.right.right.left = newNodeUtil(11);
	root.left.right.right.right = newNodeUtil(12);
	root.left.left.right.left.left = newNodeUtil(13);
	root.left.left.right.left.right = newNodeUtil(14);
	root.left.right.right.right.right = newNodeUtil(15);
	return root;
    }

    /**
     * Full binary tree: A binary tree is which each node was exactly 2 or 0
     * children
     * 
     * <pre>
     *                      1
     * 	            2             3
     *           4     5      6       7
     *               8   9        10    11
     * </pre>
     * 
     * @return
     */
    public static BinaryTreeNode<Integer> fullBinaryTree() {
	BinaryTreeNode<Integer> root = newNodeUtil(1);
	root.left = newNodeUtil(2);
	root.right = newNodeUtil(3);

	root.left.left = newNodeUtil(4);
	root.left.right = newNodeUtil(5);

	root.right.left = newNodeUtil(6);
	root.right.right = newNodeUtil(7);

	root.left.right.left = newNodeUtil(8);
	root.left.right.right = newNodeUtil(9);

	root.right.right.left = newNodeUtil(10);
	root.right.right.right = newNodeUtil(11);

	root.right.right.left.left = newNodeUtil(12);
	root.right.right.left.right = newNodeUtil(13);
	return root;
    }

    /**
     * <pre>
     * Perfect binary tree: 
     * - a binary tree with all leaf nodes at the same depth.
     * All internal nodes have exactly two children.
     * - a perfect binary tree has the maximum number of nodes for a given height
     * - a perfect binary tree has (2 (n+1) - 1) nodes where n is the height of the tree
     * Ex: 
     * 	height = 0 -> 1 node
     * 	height = 1 -> 3 node
     * 	height = 2 -> 7 node
     * </pre>
     * 
     * @return
     */
    public static BinaryTreeNode<Integer> perfectBinaryTree() {
	BinaryTreeNode<Integer> root = newNodeUtil(1);
	root.left = newNodeUtil(2);
	root.right = newNodeUtil(3);

	root.left.left = newNodeUtil(4);
	root.left.right = newNodeUtil(5);

	root.right.left = newNodeUtil(6);
	root.right.right = newNodeUtil(7);
	return root;
    }

    public static BinaryTreeNode<Integer> rightSkewedTree() {
	Integer[] num = { 1, 2, 3, 4, 5, 6, 7 };
	BinaryTreeNode<Integer> root = newNodeUtil(num[0]);
	BinaryTreeNode<Integer> t = root;
	for (int i = 1; i < num.length; i++) {
	    t.right = newNodeUtil(num[i]);
	    t = t.right;
	}
	return root;
    }

    public static BinaryTreeNode<Integer> leftSkewedTree() {
	Integer[] num = { 1, 2, 3, 4, 5, 6, 7 };
	BinaryTreeNode<Integer> root = newNodeUtil(num[0]);
	BinaryTreeNode<Integer> t = root;
	for (int i = 1; i < num.length; i++) {
	    t.left = newNodeUtil(num[i]);
	    t = t.left;
	}
	return root;
    }

    /**
     * Complete binary tree: A binary tree in which every level, except possibly
     * the deepest is completely filled. At depth n, the height of the tree, all
     * nodes are as far left as possible
     * 
     * @return
     */
    public static BinaryTreeNode<Integer> completeBinaryTree() {
	return getCompleteTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
    }

    public static <T> BinaryTreeNode<T> getCompleteTree(T[] nodes) {
	CompleteBinaryTreeListImpl<T> tree = new CompleteBinaryTreeListImpl<>();
	for (T t : nodes) {
	    tree.add(t);
	}
	return tree.root;
    }

    /**
     * <pre>
     *                                 10
     *                                 /\
     *                                /  \
     *                               /    \
     *                              /      \
     *                             5        14
     *                            / \       /\
     *                           /   \     /  \
     *                          2     9   12  19
     *                               /
     *                              /
     *                             8
     *                            /
     *                           6
     *                            \
     *                             7
     *
     * </pre>
     * 
     * @return
     */
    public static BinaryTreeNode<Integer> binarySearchTreeOne() {
	Integer[] ints = { 10, 5, 2, 14, 9, 19, 8, 6, 7, 12 };
	return binarySearchTreeUtil(ints);
    }

    /**
     * <pre>
     *                                 10
     *                                 /\
     *                                /  \
     *                               /    \
     *                              /      \
     *                             5        14
     *                            / \       / \
     *                           /   \     /   \
     *                          2     9  12     19
     *                               /   /\     /\
     *                              /   /  \   /  \
     *                             8   11  13 17  20  
     *                            /
     *                           6
     *                            \
     *                             7
     *
     * </pre>
     * 
     * @return
     */
    public static BinaryTreeNode<Integer> binarySearchTreeTwo() {
	Integer[] ints = { 10, 5, 2, 14, 9, 19, 8, 6, 7, 12, 13, 11, 20, 17 };
	return binarySearchTreeUtil(ints);
    }

    private static <T extends Comparable<T>> BinaryTreeNode<T> binarySearchTreeUtil(T[] t) {
	BSTInsert<T> bst = new BSTInsert<>();
	for (int i = 0; i < t.length; i++) {
	    bst.insert(t[i]);
	}
	return bst.root;
    }

    private static <T> BinaryTreeNode<T> newNodeUtil(T t) {
	return new BinaryTreeNode<>(t, null, null);
    }

}
