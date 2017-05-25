package com.msrm.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public int size() {
	return size;
    }

    public void enqueue(T t) {
	Node<T> n = new Node<T>();
	n.t = t;
	if (front == null) {
	    front = rear = n;
	} else {
	    rear.next = n;
	    rear = n;
	}
	size++;
    }

    public T dequeue() {
	if (front == null)
	    return null;
	T t = front.t;
	front = front.next;
	size--;
	return t;
    }

    public boolean isEmpty() {
	return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
	return new QueueIterator<>(front);
    }

    private class QueueIterator<I> implements Iterator<T> {
	private Node<T> current;

	public QueueIterator(Node<T> current) {
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
	    T t = current.t;
	    current = current.next;
	    return t;
	}

	@Override
	public void remove() {
	    throw new UnsupportedOperationException();
	}

    }

    private static class Node<T> {
	T t;
	Node<T> next;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	Iterator<T> itr = iterator();
	while (itr.hasNext()) {
	    sb.append(itr.next());
	    if (itr.hasNext())
		sb.append(",");
	}
	return sb.append("]").toString();
    }

    public static void main(String[] args) {
	Queue<Integer> q = new Queue<>();
	System.out.println(q);
	q.enqueue(4);
	System.out.println(q.dequeue());

	q.enqueue(8);
	System.out.println(q.size());
	System.out.println(q);

	System.out.println(q.dequeue());
	q.enqueue(3);
	System.out.println(q.size());
	System.out.println(q);

	for (Integer i : q) {
	    System.out.println(i);
	}

	System.out.println(q.dequeue());
	System.out.println(q.size());
	System.out.println(q);

	System.out.println(q.dequeue());
	System.out.println(q);
    }
}
