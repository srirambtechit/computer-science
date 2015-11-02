package com.datastructure;

import com.datastructure.util.BinaryTreeNode;
import com.datastructure.util.BinaryTreeUtil;
import com.datastructure.util.SampleBinaryTree;

public class CheckRelationship {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	root.right.left.left = BinaryTreeUtil.newNode(4);
	root.right.left.right = BinaryTreeUtil.newNode(4);

	// case 1 output : 6 and 8 are not cousin
	// BinaryTreeNode<Integer> nodeOne = root.right.left;
	// BinaryTreeNode<Integer> nodeTwo = root.left.right.left;

	// case 2 output : 4 and 7 are cousin
	// BinaryTreeNode<Integer> nodeOne = root.left.left;
	// BinaryTreeNode<Integer> nodeTwo = root.right.right;

	// case 3 output : 6 and 5 are cousin
	// BinaryTreeNode<Integer> nodeOne = root.right.left;
	// BinaryTreeNode<Integer> nodeTwo = root.left.right;

	// case 4 output: 4 and 5 are cousin
	BinaryTreeNode<Integer> nodeOne = root.left.left;
	BinaryTreeNode<Integer> nodeTwo = root.left.right;

	if (nodeOne != null && nodeTwo != null && cousin(root, nodeOne, nodeTwo)) {
	    System.out.printf("%d and %d are cousin", nodeOne.data, nodeTwo.data);
	} else {
	    System.out.printf("%d and %d are not cousin", nodeOne.data, nodeTwo.data);
	}
    }

    /**
     * <pre>
     * 1. Should be same level
     * 2. Should have different parent
     * 
     * @param root - Tree
     * @param nodeOne - relation one
     * @param nodeTwo - relation two
     * </pre>
     * 
     * @return
     */
    public static <T> boolean cousin(BinaryTreeNode<T> root, BinaryTreeNode<T> nodeOne, BinaryTreeNode<T> nodeTwo) {
	if (!NodeLevel.sameLevel(root, nodeOne, nodeTwo))
	    return false;
	BinaryTreeNode<T> node = LowestCommonAncestor.findLCA(root, nodeOne, nodeTwo);
	System.out.println("Least common ancestor : " + node.data);
	return node != null && !((node.left == nodeOne || node.left == nodeTwo) && (node.right == nodeOne || node.right != nodeTwo));
    }

}
