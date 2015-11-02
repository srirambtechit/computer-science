package com.datastructure.util;

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
	BinaryTreeNode<Integer> root = newNode(8);
	root.left = newNode(10);
	root.right = newNode(2);
	root.left.left = newNode(6);
	root.left.right = newNode(9);
	root.left.left.left = newNode(4);
	root.left.right.left = newNode(7);
	root.left.right.right = newNode(5);
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
	BinaryTreeNode<Integer> root = newNode(1);
	root.left = newNode(2);
	root.right = newNode(3);
	root.left.left = newNode(4);
	root.left.right = newNode(5);
	root.right.left = newNode(6);
	root.right.right = newNode(7);
	root.left.right.left = newNode(8);
	root.left.right.left.left = newNode(9);
	root.left.right.left.right = newNode(10);
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
     * @return
     */
    public static BinaryTreeNode<Integer> binaryTreeThree() {
	BinaryTreeNode<Integer> root = newNode(1);
	root.left = newNode(2);
	root.right = newNode(3);
	root.right.right = newNode(6);
	root.left.left = newNode(4);
	root.left.right = newNode(5);
	root.left.left.left = newNode(7);
	root.left.left.right = newNode(8);
	root.left.right.right = newNode(9);
	root.left.left.right.left = newNode(10);
	root.left.right.right.left = newNode(11);
	root.left.right.right.right = newNode(12);
	root.left.left.right.left.left = newNode(13);
	root.left.left.right.left.right = newNode(14);
	root.left.right.right.right.right = newNode(15);
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
	BinaryTreeNode<Integer> root = newNode(1);
	root.left = newNode(2);
	root.right = newNode(3);

	root.left.left = newNode(4);
	root.left.right = newNode(5);

	root.right.left = newNode(6);
	root.right.right = newNode(7);

	root.left.right.left = newNode(8);
	root.left.right.right = newNode(9);

	root.right.right.left = newNode(10);
	root.right.right.right = newNode(11);

	root.right.right.left.left = newNode(12);
	root.right.right.left.right = newNode(13);
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
	BinaryTreeNode<Integer> root = newNode(1);
	root.left = newNode(2);
	root.right = newNode(3);

	root.left.left = newNode(4);
	root.left.right = newNode(5);

	root.right.left = newNode(6);
	root.right.right = newNode(7);
	return root;
    }

    public static BinaryTreeNode<Integer> rightSkewedTree() {
	Integer[] num = { 1, 2, 3, 4, 5, 6, 7 };
	BinaryTreeNode<Integer> root = newNode(num[0]);
	BinaryTreeNode<Integer> t = root;
	for (int i = 1; i < num.length; i++) {
	    t.right = newNode(num[i]);
	    t = t.right;
	}
	return root;
    }

    public static BinaryTreeNode<Integer> leftSkewedTree() {
	Integer[] num = { 1, 2, 3, 4, 5, 6, 7 };
	BinaryTreeNode<Integer> root = newNode(num[0]);
	BinaryTreeNode<Integer> t = root;
	for (int i = 1; i < num.length; i++) {
	    t.left = newNode(num[i]);
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

    private static <T> BinaryTreeNode<T> newNode(T t) {
	return new BinaryTreeNode<>(t, null, null);
    }

}
