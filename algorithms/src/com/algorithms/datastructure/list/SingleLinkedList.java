package com.algorithms.datastructure.list;

import java.util.Hashtable;

public class SingleLinkedList {
    int size;

    LinkedListNode head;

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

    public String toString() {
	if (head == null)
	    return "";
	return head.toString();
    }

}
