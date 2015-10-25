package com.datastructure;

import java.util.ArrayList;
import java.util.List;

import com.datastructure.util.BinaryTreeNode;
import com.datastructure.util.BinaryTreeUtil;
import com.datastructure.util.SampleBinaryTree;

public class LowestCommonAncestor {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	BinaryTreeNode<Integer> nodeOne = root.left.right.left.right;
	BinaryTreeNode<Integer> nodeTwo = root.right.left;
	Integer data = find(root, nodeOne, nodeTwo);
	System.out.printf("LCA(%d, %d) is %d%n", nodeOne.data, nodeTwo.data, data);
    }

    @SuppressWarnings("unchecked")
    public static <T> T find(BinaryTreeNode<T> root, BinaryTreeNode<T> nodeOne, BinaryTreeNode<T> nodeTwo) {
	T[] t = (T[]) new Object[BinaryTreeUtil.height(root) + 1];
	List<T> pathOne = new ArrayList<>();
	List<T> pathTwo = new ArrayList<>();
	findPath(root, nodeOne, pathOne, t, 0);
	findPath(root, nodeTwo, pathTwo, t, 0);

	System.out.println(pathOne);
	System.out.println(pathTwo);

	// if path is empty, given node is not present at tree
	if (pathOne.isEmpty() || pathTwo.isEmpty())
	    return null;

	int i = 0;
	for (; i < pathOne.size(); i++) {
	    if (i < pathTwo.size() && pathOne.get(i) != pathTwo.get(i)) {
		break;
	    }
	}
	return pathOne.get(i - 1);
    }

    /**
     * Method to find path between root to given node
     * 
     * @param root
     * @param node
     * @param path
     * @param t
     * @param len
     * @return
     */
    private static <T> boolean findPath(BinaryTreeNode<T> root, BinaryTreeNode<T> node, List<T> path, T[] t, int len) {
	// true indicates recursion continuation
	if (root == null || node == null)
	    return true;
	t[len++] = root.data;

	// false indicates element found, stop subsequent recursion
	if (root == node) {
	    for (int i = 0; i < len; i++)
		path.add(t[i]);
	    return false;
	}
	boolean flag = findPath(root.left, node, path, t, len);
	if (flag) {
	    flag = findPath(root.right, node, path, t, len);
	}
	return flag;
    }

}
