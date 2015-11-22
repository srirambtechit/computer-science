package com.datastructure;

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

    public void add(T t) {
	pq[++N] = t;
	swim(N);
    }

    public T min() {
	if (N <= 1)
	    throw new NoSuchElementException();
	return pq[1];
    }

    public T delMin() {
	if (N <= 1)
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
	MinPQ<Integer> q = new MinPQ<>(10);

	q.add(7);
	q.add(4);
	q.add(3);
	q.add(6);
	q.add(5);
	q.add(9);
	q.add(0);
	q.add(8);
	q.add(1);

	System.out.println("Min : " + q.min());

	Iterator<Integer> itr = q.iterator();
	while (itr.hasNext()) {
	    System.out.print(itr.next() + "\t");
	}

	System.out.println("\n" + q);
	System.out.println("delMin : " + q.delMin());
	System.out.println("\n" + q);
	System.out.println("delMin : " + q.delMin());
	System.out.println("\n" + q);
	System.out.println("delMin : " + q.delMin());
	System.out.println("\n" + q);
	System.out.println("delMin : " + q.delMin());
	System.out.println("\n" + q);
	System.out.println("delMin : " + q.delMin());
	System.out.println("\n" + q);
	System.out.println("delMin : " + q.delMin());
	System.out.println("\n" + q);
	System.out.println("delMin : " + q.delMin());
	System.out.println("\n" + q);
	System.out.println("delMin : " + q.delMin());
	System.out.println("\n" + q);
	System.out.println("delMin : " + q.delMin());
	System.out.println("\n" + q);
	System.out.println("delMin : " + q.delMin());
    }

}
