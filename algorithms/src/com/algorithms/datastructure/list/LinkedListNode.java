package com.algorithms.datastructure.list;

public class LinkedListNode {
    Integer data;
    LinkedListNode next;

    public LinkedListNode(Integer data, LinkedListNode next) {
	this.data = data;
	this.next = next;
    }

    public String toString() {
	if (next == null)
	    return data.toString();
	return data + ", " + next.toString();
    }
}
