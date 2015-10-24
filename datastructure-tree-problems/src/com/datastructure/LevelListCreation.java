package com.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.datastructure.util.BinaryTreeNode;
import com.datastructure.util.SampleBinaryTree;

public class LevelListCreation {

    public static void main(String[] args) {
	BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeTwo();
	root.right.left.left = new BinaryTreeNode<>(4, null, null);
	root.right.left.right = new BinaryTreeNode<>(4, null, null);
	List<List<Integer>> allLevels = prepareLevelList(root);
	for (List<Integer> level : allLevels) {
	    System.out.println(level);
	}
    }

    public static <T> List<List<T>> prepareLevelList(BinaryTreeNode<T> root) {
	List<List<T>> allLevels = new ArrayList<>();
	if (root == null)
	    return allLevels;
	Queue<BinaryTreeNode<T>> q = new LinkedList<>();
	q.offer(root);
	q.offer(null);
	List<T> levelList = new ArrayList<>();
	while (!q.isEmpty()) {
	    root = q.poll();
	    if (root == null) {
		if (q.peek() != null) {
		    q.offer(null);
		}
		allLevels.add(levelList);
		levelList = null;
	    } else {
		if (root.left != null) {
		    q.offer(root.left);
		}
		if (root.right != null) {
		    q.offer(root.right);
		}
		if (levelList == null)
		    levelList = new ArrayList<>();
		levelList.add(root.data);
	    }
	}
	return allLevels;
    }

}
