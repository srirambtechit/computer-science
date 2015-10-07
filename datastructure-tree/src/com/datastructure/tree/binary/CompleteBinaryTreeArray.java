package com.datastructure.tree.binary;

import java.util.Arrays;

/**
 * <pre>
 * Array based implementation of CompleteBinaryTree
 * in this data structure, follow below hints
 * 
 * Assume, k is a parent node position in array,
 *  parent() = k
 *  child(k) = 2k, 2k+1
 * 
 * </pre>
 * 
 * @author sriram
 *
 */
public class CompleteBinaryTreeArray<Item> {

    private Item[] tree;
    private int ptr;

    // Construct tree by capacity
    @SuppressWarnings("unchecked")
    public CompleteBinaryTreeArray(int c) {
	tree = (Item[]) new Object[c];
    }

    public void add(Item e) {
	if (ptr == tree.length) {
	    System.out.println("Tree is full");
	    return;
	}
	tree[ptr++] = e;
    }

    public String toString() {
	if (ptr == 0)
	    return "[]";
	return Arrays.toString(tree);
    }

}
