package com.algorithms.datastructure;

public class MyList {

    private Node head = null;

    private int size;

    public int size() {
	return size;
    }

    public void add(Integer data) {
	if (head == null) {
	    head = new Node(data, null);
	} else {
	    Node node = new Node(data, null);
	    Node t = head;
	    while (t != null && t.next != null) {
		t = t.next;
	    }
	    t.next = node;
	}
	size++;
    }

    public boolean remove(Integer data) {
	if (head != null) {
	    if (head.data.equals(data)) {
		head = head.next;
		size--;
		return true;
	    }
	}

	Node curr = head;
	Node prev = null;
	while (curr != null) {
	    if (curr.data.equals(data)) {
		prev.next = curr.next;
		size--;
		return true;
	    }
	    prev = curr;
	    curr = curr.next;
	}
	return false;
    }

    public boolean contains(Integer data) {
	Node curr = head;
	while (curr != null) {
	    if (curr.data.equals(data)) {
		return true;
	    }
	    curr = curr.next;
	}
	return false;
    }

    public void reverse() {
	MyStack<Node> stack = new MyStack<>();
	Node tmp = head;
	while (tmp != null) {
	    stack.push(tmp);
	    tmp = tmp.next;
	}

	Node curr = stack.pop();
	Node newHead = curr;
	while (!stack.isEmpty()) {
	    Node prev = stack.pop();
	    curr.next = prev;
	    prev.next = null;
	    curr = prev;
	}
	head = newHead;
    }

    public String toString() {
	if (head == null)
	    return "[]";
	return head.toString();
    }

    private class Node {
	Integer data;
	Node next;

	private Node(Integer data, Node next) {
	    this.data = data;
	    this.next = next;
	}

	public Node clone() {
	    if (next == null)
		return null;
	    return this.clone();
	}

	public String toString() {
	    if (next == null) {
		return data.toString();
	    }
	    return data + ", " + next.toString();
	}
    }
}
