package com.msrm.datastructure.priorityqueue;

import java.util.Arrays;
import java.util.Iterator;

/**
 * MaximumPriorityQueue - root will be greater than its children
 * 
 * @author sriram
 *
 * @param <Item>
 */
public class MaxPQ<Item extends Comparable<Item>> implements Iterable<Item> {

	private Item[] pq;

	private int ptr;

	@SuppressWarnings("unchecked")
	public MaxPQ(int c) {
		pq = (Item[]) new Comparable[c];
		ptr++; // skipping index 0
	}

	public void add(Item e) {
		if (ptr == pq.length)
			return;
		int k = ptr++;
		pq[k] = e;
		swim(k);
	}

	public Item delMax() {
		if (ptr == 1)
			return null;
		int k = --ptr;
		swap(1, k);
		Item e = pq[k];
		pq[k] = null;
		sink(1);
		return e;
	}

	public boolean isEmpty() {
		return ptr == 1;
	}

	public int size() {
		return ptr - 1;
	}

	private void sink(int k) {
		int n = pq.length;
		while (2 * k < n) {
			int j = 2 * k;
			if (less(j, j + 1))
				j++;
			if (less(j, k))
				break;
			swap(j, k);
			k = j;
		}
	}

	private void swim(int k) {
		while (k > 1) {
			if (less(k, k / 2))
				break;
			swap(k, k / 2);
			k = k / 2;
		}
	}

	private boolean less(int i, int j) {
		if (pq[i] == null || pq[j] == null)
			return false;
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void swap(int i, int j) {
		Item t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}

	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Item> {

		private int qPtr;

		@Override
		public boolean hasNext() {
			return qPtr != ptr - 1;
		}

		@Override
		public Item next() {
			Item i = null;
			if (qPtr < ptr) {
				i = pq[++qPtr];
			}
			return i;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	public String toString() {
		return Arrays.toString(pq);
	}

}
