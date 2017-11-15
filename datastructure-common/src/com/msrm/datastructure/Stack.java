package com.msrm.datastructure;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

	private Node<T> top;
	private int size;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void push(T t) {
		Node<T> node = new Node<>();
		node.t = t;
		node.next = top;
		top = node;
		size++;
	}

	public T pop() {
		if (top == null)
			return null;
		T t = top.t;
		top = top.next;
		size--;
		return t;
	}

	@Override
	public Iterator<T> iterator() {
		return new StackIterator<>(top);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Iterator<T> itr = iterator();
		while (itr.hasNext()) {
			sb.append(itr.next());
			if (!itr.hasNext())
				return sb.append("]").toString();
			sb.append(",");

		}
		return "[]";
	}

	private static class StackIterator<T> implements Iterator<T> {
		private Node<T> current;

		private StackIterator(Node<T> current) {
			this.current = current;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if (!hasNext())
				return null;
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

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		System.out.println(s);
		s.push(3);
		s.push(8);
		s.push(4);
		s.push(1);
		System.out.println(s);

		Iterator<Integer> i = s.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s);
	}

}
