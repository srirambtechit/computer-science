package com.algorithms.datastructure.list;

import java.util.List;

public class ListApplication {

    public static void main(String[] args) {
	SingleLinkedList list = new SingleLinkedList();
	list.add(81);
	list.add(42);
	list.add(53);
	list.add(44);
	list.add(25);
	list.add(76);

	System.out.println(list);

	List<SingleLinkedList> lists = SingleLinkedList.frontBackSplit(list);
	System.out.println(lists);

	SingleLinkedList sortedList = new SingleLinkedList();
	sortedList.add(1);
	sortedList.add(2);
	sortedList.add(2);
	sortedList.add(3);
	sortedList.add(5);
	sortedList.add(7);
	sortedList.add(7);
	sortedList.add(7);
	sortedList.add(9);

	System.out.println("sortedList : " + sortedList);
	sortedList.removeDupsSortedList();
	System.out.println("sortedList : " + sortedList);

    }

}
