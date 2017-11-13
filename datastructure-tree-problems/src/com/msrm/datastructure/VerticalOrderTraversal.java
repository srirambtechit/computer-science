package com.msrm.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.msrm.datastructure.util.BinaryTreeNode;
import com.msrm.datastructure.util.BinaryTreeUtil;
import com.msrm.datastructure.util.SampleBinaryTree;

public class VerticalOrderTraversal {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = SampleBinaryTree.binaryTreeThree();
		root.right.right.right = BinaryTreeUtil.newNode(100);
		root.right.right.right.right = BinaryTreeUtil.newNode(101);
		printVertical(root);
		verticalSum(root);
	}

	public static void verticalSum(BinaryTreeNode<Integer> root) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		vertical(root, 0, map);
		int i = 1;
		for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
			System.out.printf("%d	%d%n", i++, sumOfList(entry.getValue()));
		}
	}

	private static int sumOfList(List<Integer> list) {
		int s = 0;
		for (Integer i : list) {
			s += i;
		}
		return s;
	}

	public static <T> void printVertical(BinaryTreeNode<T> root) {
		Map<Integer, List<T>> map = new HashMap<>();
		vertical(root, 0, map);
		for (Entry<Integer, List<T>> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	/**
	 * method used to traverse tree based on horizontal distance
	 * 
	 * @param root
	 * @param hd
	 */
	private static <T> void vertical(BinaryTreeNode<T> root, int hd, Map<Integer, List<T>> map) {
		if (root == null)
			return;
		if (map.get(hd) == null) {
			map.put(hd, new ArrayList<T>());
			map.get(hd).add(root.data);
		} else {
			map.get(hd).add(root.data);
		}
		vertical(root.left, hd - 1, map);
		vertical(root.right, hd + 1, map);
	}

}
