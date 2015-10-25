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
	// BinaryTreeNode<Integer> nodeTwo = root.right.left;
	BinaryTreeNode<Integer> nodeTwo = BinaryTreeUtil.newNode(83);

	Integer data = find(root, nodeOne, nodeTwo);
	System.out.printf("LCA(%d, %d) is %d%n", nodeOne.data, nodeTwo.data, data);
	BinaryTreeNode<Integer> res = findLCA(root, nodeOne, nodeTwo);
	System.out.printf("LCA(%d, %d) is %d%n", nodeOne.data, nodeTwo.data, res != null ? res.data : null);
    }

    static class Found {
	boolean one = false;
	boolean two = false;

	@Override
	public String toString() {
	    return "Found [one=" + one + ", two=" + two + "]";
	}

    }

    public static <T> BinaryTreeNode<T> findLCA(BinaryTreeNode<T> root, BinaryTreeNode<T> nodeOne, BinaryTreeNode<T> nodeTwo) {
	System.out.println("nodeOne : " + nodeOne.data + "; nodeTwo : " + nodeTwo.data);
	Found f = new Found();
	BinaryTreeNode<T> res = findLCA(root, nodeOne, nodeTwo, f);
	System.out.println("one=" + f.one + "; two=" + f.two + ";res=" + res);
	if (!f.one || !f.two)
	    return null;
	return res;
    }

    /**
     * Solution1:- Time
     * 
     * @param root
     * @param nodeOne
     * @param nodeTwo
     * @return
     */
    private static <T> BinaryTreeNode<T> findLCA(BinaryTreeNode<T> root, BinaryTreeNode<T> nodeOne, BinaryTreeNode<T> nodeTwo, Found f) {
	if (root == null)
	    return null;
	if (root == nodeOne) {
	    f.one = true;
	}
	if (root == nodeTwo) {
	    f.two = true;
	}
	if (root == nodeOne || root == nodeTwo)
	    return root;
	BinaryTreeNode<T> leftLCANode = findLCA(root.left, nodeOne, nodeTwo, f);
	BinaryTreeNode<T> rightLCANode = findLCA(root.right, nodeOne, nodeTwo, f);
	if (leftLCANode != null && rightLCANode != null)
	    return root;
	return rightLCANode != null ? rightLCANode : leftLCANode;
    }

    @SuppressWarnings("unchecked")
    public static <T> T find(BinaryTreeNode<T> root, BinaryTreeNode<T> nodeOne, BinaryTreeNode<T> nodeTwo) {
	T[] t = (T[]) new Object[BinaryTreeUtil.height(root) + 1];
	List<T> pathOne = new ArrayList<>();
	List<T> pathTwo = new ArrayList<>();
	findPath(root, nodeOne, pathOne, t, 0);
	findPath(root, nodeTwo, pathTwo, t, 0);

	// for debug purpose
	// System.out.println(pathOne);
	// System.out.println(pathTwo);

	// if path is empty, given node is not present at tree
	if (pathOne.isEmpty() || pathTwo.isEmpty())
	    return null;
	int i = 0;
	for (; i < pathOne.size() && i < pathTwo.size(); i++) {
	    if (pathOne.get(i) != pathTwo.get(i)) {
		break;
	    }
	}
	return pathOne.size() > pathTwo.size() ? pathOne.get(i - 1) : pathTwo.get(i - 1);
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
