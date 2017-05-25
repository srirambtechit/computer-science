package com.msrm.datastructure;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;

public class IsometricTreeComparison {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> treeOne = BinaryTreeUtil.newNode(1);
	treeOne.left = BinaryTreeUtil.newNode(2);
	treeOne.right = BinaryTreeUtil.newNode(3);

	BinaryTreeNode<Integer> treeTwo = BinaryTreeUtil.newNode(1);
	treeTwo.left = BinaryTreeUtil.newNode(2);
	treeTwo.right = BinaryTreeUtil.newNode(3);

	System.out.println("Isometric : " + areIsometric(treeOne, treeTwo));
	System.out.println("Isometric : " + areIsometric(null, null));

	treeTwo.right = null;
	System.out.println("Isometric : " + areIsometric(treeOne, treeTwo));
    }

    /**
     * Method returns true if two trees are structurally equal and data doesn't
     * matter, otherwise false
     * 
     * @param t1
     * @param t2
     * @return
     */
    public static <T> boolean areIsometric(BinaryTreeNode<T> t1, BinaryTreeNode<T> t2) {
	if (t1 == null && t2 == null)
	    return true;
	return t1 != null && t2 != null && areIsometric(t1.left, t2.left) && areIsometric(t1.right, t2.right);
    }

}
