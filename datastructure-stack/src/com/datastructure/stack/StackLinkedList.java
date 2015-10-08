package com.datastructure.stack;

import java.util.Iterator;

public class StackLinkedList<Item> implements Iterable<Item> {

    private Node head;

    public void push(Item item) {
	Node node = new Node(item, null);
	node.next = head;
	head = node;
    }

    public Item pop() {
	if (head == null)
	    return null;
	Item item = head.data;
	head.data = null;
	head = head.next;
	return item;
    }
    
    public boolean contains(Item i) {
	
	return false;
    }

    public String toString() {
	if (head == null)
	    return "[]";
	return head.toString();
    }

    @Override
    public Iterator<Item> iterator() {
	return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

	private Node first = head;

	@Override
	public boolean hasNext() {
	    return first != null;
	}

	@Override
	public Item next() {
	    Item d = first.data;
	    first = first.next;
	    return d;
	}

	@Override
	public void remove() {
	    throw new UnsupportedOperationException();
	}

    }

    private class Node {
	Item data;
	Node next;

	Node(Item data, Node next) {
	    this.data = data;
	    this.next = next;
	}

	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    Node t = this;
	    sb.append("[");
	    while (t != null) {
		sb.append(t.data);
		if (t.next != null)
		    sb.append(", ");
		t = t.next;
	    }
	    sb.append("]");
	    return sb.toString();
	}
    }

}
