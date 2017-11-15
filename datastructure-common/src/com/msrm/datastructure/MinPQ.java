package com.msrm.datastructure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinPQ<T extends Comparable<T>> implements Iterable<T> {

	private T[] pq;
	private int N;

	@SuppressWarnings("unchecked")
	public MinPQ(int capacity) {
		pq = (T[]) new Comparable[capacity + 1];
	}

	public void insert(T t) {
		pq[++N] = t;
		swim(N);
	}

	public T min() {
		if (N < 1)
			throw new NoSuchElementException();
		return pq[1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public T delMin() {
		if (N < 1)
			throw new NoSuchElementException();
		T m = pq[1];
		pq[1] = pq[N];
		pq[N--] = null;
		sink(1);
		return m;
	}

	private void sink(int k) {
		int j;
		while (2 * k <= N) {
			j = 2 * k;
			if (j < N && less(j + 1, j))
				j = j + 1;
			if (less(k, j))
				break;
			swap(j, k);
			k = j;
		}
	}

	private void swim(int k) {
		while (k > 1) {
			if (!less(k, k / 2))
				break;
			swap(k, k / 2);
			k = k / 2;
		}
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void swap(int i, int j) {
		T t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}

	@Override
	public Iterator<T> iterator() {
		return new MinPQIterator();
	}

	private class MinPQIterator implements Iterator<T> {

		private int cursor;

		@Override
		public boolean hasNext() {
			return cursor != pq.length - 1 && pq[cursor + 1] != null;
		}

		@Override
		public T next() {
			return pq[++cursor];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	public String toString() {
		return Arrays.toString(pq);
	}

	public static void main(String[] args) {
		MinPQ<Integer> pq = new MinPQ<>(10);
		System.out.println("isEmpty : " + pq.isEmpty());

		pq.insert(7);
		System.out.println("N : " + pq.N);
		System.out.println("isEmpty : " + pq.isEmpty());

		pq.insert(4);
		pq.insert(3);
		pq.insert(6);
		pq.insert(5);
		pq.insert(9);
		pq.insert(0);
		pq.insert(8);
		pq.insert(1);

		System.out.println("isEmpty : " + pq.isEmpty());

		System.out.println("Min : " + pq.min());

		Iterator<Integer> itr = pq.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + "\t");
		}
		try {
			System.out.println();

			for (int i = 0; i < 10; i++) {
				System.out.println("before : " + pq);
				System.out.println("delMin   : " + pq.delMin());
				System.out.println("after  : " + pq);
				System.out.println("N        : " + pq.N);
				System.out.println("\n");
			}

		} catch (Exception e) {
			System.out.println();
		}
		System.out.println("isEmpty : " + pq.isEmpty());
		System.out.println("N : " + pq.N);
	}

}
