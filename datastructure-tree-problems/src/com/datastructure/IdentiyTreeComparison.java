package com.datastructure;

import com.datastructure.util.BinaryTreeNode;
import com.datastructure.util.BinaryTreeUtil;

public class IdentiyTreeComparison {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> treeOne = BinaryTreeUtil.newNode(1);
	treeOne.left = BinaryTreeUtil.newNode(2);
	treeOne.right = BinaryTreeUtil.newNode(3);

	BinaryTreeNode<Integer> treeTwo = BinaryTreeUtil.newNode(1);
	treeTwo.left = BinaryTreeUtil.newNode(2);
	treeTwo.right = BinaryTreeUtil.newNode(3);

	System.out.println("Identical : " + areIdentical(treeOne, treeTwo));
	System.out.println("Identical : " + areIdentical(null, null));
	treeTwo.right = BinaryTreeUtil.newNode(4);
	System.out.println("Identical : " + areIdentical(treeOne, treeTwo));
    }

    /**
     * Method returns true if two trees are structurally equal and same data
     * otherwise false
     * 
     * @param t1
     * @param t2
     * @return
     */
    public static <T> boolean areIdentical(BinaryTreeNode<T> t1, BinaryTreeNode<T> t2) {
	if (t1 == null && t2 == null)
	    return true;
	return t1 != null && t2 != null && t1.data.equals(t2.data) && areIdentical(t1.left, t2.left) && areIdentical(t1.right, t2.right);
    }

}
