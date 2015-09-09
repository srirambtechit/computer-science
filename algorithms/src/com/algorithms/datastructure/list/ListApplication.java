package com.algorithms.datastructure.list;

import java.util.List;

public class ListApplication {

    public static void main(String[] args) {

	testFrontBackSplit();

	testRemoveDupsSortedList();

	testMoveNode();

	testAlternateSplit();

	testShuffleMerge();

    }

    public static void testShuffleMerge() {
	SingleLinkedList listOne = new SingleLinkedList();
	listOne.add(81);
	listOne.add(42);
	listOne.add(53);
	listOne.add(51);
	System.out.println("listOne : " + listOne);

	SingleLinkedList listTwo = new SingleLinkedList();
	listTwo.add(44);
	listTwo.add(25);
	listTwo.add(76);
	listTwo.add(25);
	listTwo.add(76);
	System.out.println("listTwo : " + listTwo);

	SingleLinkedList newList = SingleLinkedList.shuffleMerge(listOne, listTwo);
	System.out.println("newList : " + newList);
    }

    public static void testAlternateSplit() {
	SingleLinkedList list = new SingleLinkedList();
	list.add(81);
	list.add(42);
	list.add(53);
	list.add(44);
	list.add(25);
	list.add(76);

	System.out.println("original : " + list);

	List<SingleLinkedList> result = SingleLinkedList.alternateSplit(list);
	System.out.println("subLists : " + result);
    }

    public static void testFrontBackSplit() {
	SingleLinkedList list = new SingleLinkedList();
	list.add(81);
	list.add(42);
	list.add(53);
	list.add(44);
	list.add(25);
	list.add(76);

	System.out.println("inputList     : " + list);

	List<SingleLinkedList> lists = SingleLinkedList.frontBackSplit(list);
	System.out.println("frontBackList : " + lists);
    }

    public static void testRemoveDupsSortedList() {

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

    public static void testMoveNode() {
	SingleLinkedList listOne = new SingleLinkedList();
	listOne.add(1);
	listOne.add(2);
	listOne.add(3);

	SingleLinkedList listTwo = new SingleLinkedList();
	listTwo.add(5);
	listTwo.add(6);
	listTwo.add(7);
	listTwo.add(9);

	System.out.println("listOne : " + listOne);
	System.out.println("listTwo : " + listTwo);

	SingleLinkedList.moveNode(listOne, listTwo);

	System.out.println("listOne : " + listOne);
	System.out.println("listTwo : " + listTwo);

    }

}
