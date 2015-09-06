package com.algorithms.datastructure;

import com.algorithms.datastructure.list.SingleLinkedList;

public class MyListApp {

    public static void main(String[] args) {
	MyList list = new MyList();
	System.out.println(list);
	for (int i = 0; i < 7; i++) {
	    add(list, (int) (Math.random() * 100));
	}

	int[] arr = { 27, 5, 79, 28, 36, 79, 51 };
	MyList newList = new MyList();
	System.out.println(newList);
	for (int i : arr) {
	    add(newList, i);
	}
	System.out.println(newList);

	SingleLinkedList sList = new SingleLinkedList();
	System.out.println(sList);
	sList.add(4);
	sList.add(8);
	sList.add(3);
	sList.add(8);
	sList.add(5);
	sList.add(9);
	sList.add(3);
	System.out.println(sList);

	sList.removeDupsTwo();
	System.out.println(sList);
    }

    public static void add(MyList list, Integer data) {
	System.out.println("Adding element to MyList " + data);
	list.add(data);
	System.out.println(list);
	System.out.println();
    }
}
