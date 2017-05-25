package com.msrm.datastructure;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;

public class MirrorTreeComparison {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> treeOne = BinaryTreeUtil.newNode(1);
	treeOne.left = BinaryTreeUtil.newNode(2);
	treeOne.right = BinaryTreeUtil.newNode(3);

	BinaryTreeNode<Integer> treeTwo = BinaryTreeUtil.newNode(1);
	treeTwo.left = BinaryTreeUtil.newNode(3);
	treeTwo.right = BinaryTreeUtil.newNode(2);

	System.out.println("Mirrors : " + areMirrors(treeOne, treeTwo));
	System.out.println("Mirrors : " + areMirrors(null, null));
	treeTwo.right = BinaryTreeUtil.newNode(4);
	System.out.println("Mirrors : " + areMirrors(treeOne, treeTwo));
    }

    /**
     * Both tree has same node and children but the left exists on right side
     * and right exists on left side
     * 
     * @param treeOne
     * @param treeTwo
     * @return
     */
    private static boolean areMirrors(BinaryTreeNode<Integer> t1, BinaryTreeNode<Integer> t2) {
	if (t1 == null && t2 == null)
	    return true;
	return t1 != null && t2 != null && t1.data.equals(t2.data) && areMirrors(t1.left, t2.right) && areMirrors(t1.right, t2.left);
    }

}
