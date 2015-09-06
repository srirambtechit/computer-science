package com.algorithms.datastructure.list;

import java.util.List;

public class ListApplication {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);

		System.out.println(list);

		List<SingleLinkedList> lists = SingleLinkedList.frontBackSplit(list);
		System.out.println(lists);
	}

}
