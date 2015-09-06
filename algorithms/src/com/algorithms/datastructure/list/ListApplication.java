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
    }

}
