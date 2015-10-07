package com.datastructure.tree.binary;

public class App {

    public static void main(String[] args) {
	CompleteBinaryTreeArray<Integer> arr = new CompleteBinaryTreeArray<>(3);
	System.out.println(arr);
	arr.add(3);
	arr.add(4);
	arr.add(41);
	System.out.println(arr);

	CompleteBinaryTreeList<Integer> tree = new CompleteBinaryTreeList<>();
	tree.add(3);
	tree.add(5);
	tree.add(1);
	tree.add(7);
	tree.add(9);
	tree.add(10);
	System.out.println(tree);
    }
}
