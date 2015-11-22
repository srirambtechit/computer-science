package com.datastructure.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bucket<T> implements Iterable<T> {

    private Node<T> head;

    private int size;

    public int size() {
	return size;
    }

    public void add(T t) {
	Node<T> n = new Node<>(t, head);
	head = n;
	size++;
    }

    @Override
    public Iterator<T> iterator() {
	return new BucketIterator<>(head);
    }

    private static class Node<T> {
	private T t;
	private Node<T> next;

	private Node(T t, Node<T> next) {
	    this.t = t;
	    this.next = next;
	}
    }

    private class BucketIterator<I> implements Iterator<T> {

	private Node<T> current;

	private BucketIterator(Node<T> current) {
	    this.current = current;
	}

	@Override
	public boolean hasNext() {
	    return current != null;
	}

	@Override
	public T next() {
	    if (!hasNext()) {
		throw new NoSuchElementException();
	    }
	    Node<T> node = current;
	    current = current.next;
	    return node.t;
	}

	@Override
	public void remove() {
	    throw new UnsupportedOperationException();
	}

    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	Iterator<T> itr = iterator();
	sb.append("[");
	while (itr.hasNext()) {
	    sb.append(itr.next());
	    if (itr.hasNext())
		sb.append(", ");
	}
	sb.append("]");
	return sb.toString();
    }

    public static void main(String[] args) {
	Bucket<Integer> b = new Bucket<>();
	b.add(3);
	b.add(8);
	b.add(9);
	b.add(2);
	b.add(1);

	Iterator<Integer> itr = b.iterator();
	while (itr.hasNext()) {
	    System.out.println(itr.next());
	}

	Iterator<Integer> itr2 = b.iterator();
	while (itr2.hasNext()) {
	    System.out.println(itr2.next());
	}

    }

}