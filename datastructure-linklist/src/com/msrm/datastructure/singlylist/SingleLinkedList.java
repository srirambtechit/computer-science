package com.msrm.datastructure.singlylist;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

public class SingleLinkedList {

	private int size;

	private LinkedListNode head;

	/**
	 * Get no. of elements present in the list
	 * 
	 * @return
	 */
	public int count() {
		return this.size;
	}

	public void add(Integer data) {
		if (head == null) {
			head = new LinkedListNode(data, null);
		} else {
			LinkedListNode t = head;
			while (t.next != null) {
				t = t.next;
			}
			t.next = newNode(data);
		}
	}

	/**
	 * <pre>
	 * insert data to the list according to the index given.
	 * if size == 0, index should be 0
	 * if size == 3, index can be of 0, 1, 2
	 * &#64;param data - data to be added
	 * &#64;param index - range from 0 to (size - 1)
	 * </pre>
	 */
	public void addAt(Integer data, int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException(String.format("%d <= %d", index, size));

		LinkedListNode newNode = new LinkedListNode(data, null);

		if (index == 0) {
			// case1: no list, index = 0
			if (head == null) {
				add(data);
			}
			// case2: 1 node, index = 0
			else {
				newNode.next = head;
				head = newNode;
				size++;
			}
			return;
		}

		// case3: more than 1 node present in list
		// find one node before for the given index since holding the next
		// node's reference
		LinkedListNode t = head;
		index--;
		for (; t.next != null && index > 0; t = t.next, index--);

		newNode.next = t.next;
		t.next = newNode;
		size++;
	}

	public void sortedInsert(Integer data) {
		LinkedListNode newNode = new LinkedListNode(data, null);
		// case 1: List is empty
		if (head == null) {
			head = newNode;
		}
		// case 2: List has 1 node
		else if (head.data > data) {
			newNode.next = head;
			head = newNode;
		}
		// case 3: List has more than 1 node
		else {
			LinkedListNode runner = head;
			while (runner != null && runner.next != null) {
				if (runner.next.data > data) {
					break;
				}
				runner = runner.next;
			}
			// case 3a: if runner reaches last node
			if (runner.next == null) {
				runner.next = newNode;
			}
			// case 3b: if runner is middle node
			else {
				newNode.next = runner.next;
				runner.next = newNode;
			}

		}
	}

	/**
	 * Add data as a head node of list
	 * 
	 * @param data
	 */
	public void push(Integer data) {
		LinkedListNode newNode = new LinkedListNode(data, null);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	/**
	 * Delete head node
	 * 
	 * @return
	 */
	public Integer pop() {
		if (head == null)
			return null;
		else {
			Integer data = head.data;
			LinkedListNode next = head.next;
			head.next = head = null;
			head = next;
			return data;
		}
	}

	/**
	 * Deleting the entire linked list
	 */
	public void deleteList() {
		LinkedListNode t = head;
		while (t != null) {
			LinkedListNode node = t;
			t = t.next;
			if (node != null) {
				node.next = null;
				node = null;
			}
		}
		head = null;
		size = 0;
	}

	/**
	 * <pre>
	 * &#64;param n  - is an index of element in the list
	 * &#64;return - element present at index, null if not
	 * </pre>
	 */
	public Integer getNth(int n) {
		if (n < 0)
			throw new IndexOutOfBoundsException(String.format("%d < 0", n));

		if (head == null)
			return null;

		LinkedListNode t = head;
		while (t != null && n > 0) {
			t = t.next;
			n--;
		}
		return t.data;
	}

	public void sortListByData() {
		if (head == null)
			return;

		LinkedListNode runner1 = head;
		while (runner1 != null) {
			LinkedListNode runner2 = runner1.next;
			while (runner2 != null) {
				if (runner1.data > runner2.data) {
					Integer t = runner2.data;
					runner2.data = runner1.data;
					runner1.data = t;
					break;
				}
				runner2 = runner2.next;
			}
			runner1 = runner1.next;
		}

	}

	public LinkedListNode appendList(SingleLinkedList list) {
		if (head == null && list != null)
			return head = list.head;

		if (head != null && list == null)
			return head;

		LinkedListNode t = head;
		while (t.next != null) {
			t = t.next;
		}
		t.next = list.head;
		return head;
	}

	/**
	 * <pre>
	 * Sublist on SingleLinkedList:-
	 * 
	 * Problem statement:- Given a list, split it into two
	 * sublists  one for the front half, and one for the back half. If the
	 * number of elements is odd, the extra element should go in the front list.
	 * So FrontBackSplit() on the list {2, 3, 5, 7, 11} should yield the two
	 * lists {2, 3, 5} and {7, 11}.
	 * 
	 * &#64;param listOne
	 * &#64;return - list of sublists
	 * </pre>
	 */
	public static List<SingleLinkedList> frontBackSplit(SingleLinkedList listOne) {
		LinkedListNode slow = listOne.head;
		LinkedListNode fast = listOne.head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null)
				fast = fast.next;
		}

		List<SingleLinkedList> result = new ArrayList<>();
		result.add(listOne);

		if (slow.next != null) {
			// making sublists
			SingleLinkedList listTwo = new SingleLinkedList();

			// slow pointer will be stopped at mid of list so take
			// next element as second list's header node
			listTwo.head = slow.next;

			// cutting the list by making next pointer to null, first list
			// becomes first list
			slow.next = null;
			result.add(listTwo);
		}
		return result;
	}

	private LinkedListNode newNode(Integer data) {
		return new LinkedListNode(data, null);
	}

	public boolean remove(Integer data) {
		if (data == null || head == null)
			return false;

		if (head != null && head.data.equals(data)) {
			head = head.next;
			return true;
		}

		LinkedListNode t = head;
		while (t.next != null) {
			if (t.next.data.equals(data)) {
				t.next = t.next.next;
				return true;
			}
			t = t.next;
		}
		return false;
	}

	// Space - O(n); Time - O(n)
	public void removeDupsOne() {
		Hashtable<Integer, Boolean> table = new Hashtable<>();
		LinkedListNode curr = head;
		LinkedListNode prev = null;

		while (curr != null) {
			if (table.containsKey(curr.data)) {
				prev.next = curr.next;
			} else {
				table.put(curr.data, true);
				prev = curr;
			}
			curr = curr.next;
		}
	}

	// Space - O(1); Time - O(n^2)
	public void removeDupsTwo() {
		if (head == null)
			return;

		LinkedListNode curr = head;

		while (curr != null) {
			LinkedListNode runner = curr;
			while (runner.next != null) {
				if (runner.next.data.equals(curr.data)) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			curr = curr.next;
		}
	}

	/**
	 * Write a RemoveDuplicates() function which takes a list sorted in
	 * increasing order and deletes any duplicate nodes from the list. Ideally,
	 * the list should only be traversed once.
	 */
	public void removeDupsSortedList() {
		if (head == null) {
			return;
		}

		LinkedListNode curr = head;
		while (curr != null) {
			if (curr.next != null && curr.data.equals(curr.next.data)) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}
	}

	/**
	 * This is a variant on Push(). Instead of creating a new node and pushing
	 * it onto the given list, MoveNode() takes two lists, removes the front
	 * node from the second list and pushes it onto the front of the first. This
	 * turns out to be a handy utility function to have for several later
	 * problems. Both Push() and MoveNode() are designed around the feature that
	 * list operations work most naturally at the head of the list
	 * 
	 * @param dest
	 * @param src
	 */
	public static void moveNode(SingleLinkedList dest, SingleLinkedList src) {

		if (dest == null || src == null)
			throw new IllegalArgumentException("Input is null");

		if (src.head == null)
			throw new IllegalArgumentException("Source list is empty");

		// Taking backup of listTwo's head node
		LinkedListNode headTwo = src.head;

		// Removing listTwo's current head and making second node as head node
		// of listTwo
		src.head = src.head.next;

		// Making listOne's head to point headTwo's next
		headTwo.next = dest.head;

		// Setting headTwo as head node of listOne
		dest.head = headTwo;

	}

	private static void alternateSplit(SingleLinkedList original, SingleLinkedList listOne, SingleLinkedList listTwo) {
		if (original == null || original.head == null) {
			return;
		}
		SingleLinkedList.moveNode(listOne, original);
		SingleLinkedList.moveNode(listTwo, original);
		alternateSplit(original, listOne, listTwo);
	}

	/**
	 * Write a function AlternatingSplit() which takes one list and divides up
	 * its nodes to make two smaller lists. The sublists should be made from
	 * alternating elements in the original list. So if the original list is {a,
	 * b, a, b, a}, then one sublist should be {a, a, a} and the other should be
	 * {b, b}. You may want to use MoveNode() as a helper. The elements in the
	 * new lists may be in any order (for some implementations, it turns out to
	 * be convenient if they are in the reverse order from the original list.)
	 * 
	 * @param original
	 * @return
	 */
	public static List<SingleLinkedList> alternateSplit(SingleLinkedList original) {
		if (original == null)
			throw new IllegalArgumentException("Input is null");

		List<SingleLinkedList> subLists = new ArrayList<>();
		SingleLinkedList listOne = new SingleLinkedList();
		SingleLinkedList listTwo = new SingleLinkedList();
		subLists.add(listOne);
		subLists.add(listTwo);
		alternateSplit(original, listOne, listTwo);
		return subLists;
	}

	/**
	 * Given two lists, merge their nodes together to make one list, taking
	 * nodes alternately between the two lists. So ShuffleMerge() with {1, 2, 3}
	 * and {7, 13, 1} should yield {1, 7, 2, 13, 3, 1}. If either list runs out,
	 * all the nodes should be taken from the other list. The solution depends
	 * on being able to move nodes to the end of a list as discussed in the
	 * Section 1 review. You may want to use MoveNode() as a helper. Overall,
	 * many techniques are possible: dummy node, local reference, or recursion.
	 * Using this function and FrontBackSplit(), you could simulate the
	 * shuffling of cards.
	 * 
	 * @param listOne
	 * @param listTwo
	 * @return
	 */
	public static SingleLinkedList shuffleMerge(SingleLinkedList listOne, SingleLinkedList listTwo) {
		SingleLinkedList result = new SingleLinkedList();
		while ((listOne != null && listOne.head != null) || (listTwo != null && listTwo.head != null)) {
			if (listOne != null && listOne.head != null) {
				moveNode(result, listOne);
			}
			if (listTwo != null && listTwo.head != null) {
				moveNode(result, listTwo);
			}
		}
		return result;
	}

	/**
	 * Write a SortedMerge() function which takes two lists, each of which is
	 * sorted in increasing order, and merges the two together into one list
	 * which is increasing order. SortedMerge() should return the new list. The
	 * new list should be made by splicing together the nodes of the first two
	 * lists (use MoveNode()). Ideally, Merge() should only make one pass
	 * through each list. Merge() is tricky to get right — it may be solved
	 * iteratively or recursively. There are many cases to deal with: either 'a'
	 * or 'b' may be empty, during processing either 'a' or 'b' may run out
	 * first, and finally there's the problem of starting the result list empty,
	 * and building it up while going through 'a' and 'b'.
	 * 
	 * @return
	 */
	public static SingleLinkedList sortedMerge(SingleLinkedList sortedListOne, SingleLinkedList sortedListTwo) {
		if (sortedListOne == null || sortedListTwo == null) {
			throw new IllegalArgumentException("Input is null");
		}

		SingleLinkedList result = new SingleLinkedList();

		LinkedListNode nodeOne = sortedListOne.head;
		LinkedListNode nodeTwo = sortedListTwo.head;
		LinkedListNode resultNode = result.head;

		while (nodeOne != null || nodeTwo != null) {
			Integer dataOne = null;
			Integer dataTwo = null;
			if (nodeOne != null) {
				dataOne = nodeOne.data;
			}
			if (nodeTwo != null) {
				dataTwo = nodeTwo.data;
			}
			if (resultNode == null) {
				if (dataOne < dataTwo)
					result.add(dataOne);
				else
					result.add(dataTwo);
			} else {

			}
		}

		return result;
	}

	/**
	 * Implement a function to check a linkedList is palindrome Time : O(n)
	 * Space: O(n / 2)
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isPalindrome(SingleLinkedList list) {
		Stack<Integer> stack = new Stack<>();
		LinkedListNode fast, slow;
		fast = list.head;
		slow = list.head;
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast != null) {
			slow = slow.next;
		}

		while (slow != null) {
			Integer top = stack.pop();
			if (!top.equals(slow.data)) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

	public String toString() {
		if (head == null)
			return "[]";
		return "[" + head.toString() + "]";
	}

}
