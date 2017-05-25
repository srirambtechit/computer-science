package com.msrm.datastructure;

import java.util.ArrayList;
import java.util.List;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;
import com.msrm.datastructure.util.SampleBinaryTree;

public class AllPaths {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	List<List<Integer>> paths = findAllPaths(root);
	for (List<Integer> path : paths) {
	    System.out.println(path);
	}
    }

    @SuppressWarnings("unchecked")
    public static <T> List<List<T>> findAllPaths(BinaryTreeNode<T> root) {
	List<List<T>> paths = new ArrayList<>();
	// max number of node in a path is equal to height of tree + 1
	// Note: height impl is based on number of edges
	// so add 1 to get node count in a path
	T[] o = (T[]) new Object[BinaryTreeUtil.height(root) + 1];
	findPath(root, paths, o, 0);
	return paths;
    }

    private static <T> void findPath(BinaryTreeNode<T> root, List<List<T>> paths, T[] t, int len) {
	if (root == null)
	    return;
	t[len++] = root.data;

	// arrived leaf node
	if (root.left == null && root.right == null) {
	    ArrayList<T> path = new ArrayList<T>();
	    for (int i = 0; i < len; i++) {
		path.add(t[i]);
	    }
	    paths.add(path);
	}
	findPath(root.left, paths, t, len);
	findPath(root.right, paths, t, len);
    }

}
