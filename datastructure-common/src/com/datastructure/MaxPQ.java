package com.datastructure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPQ<T extends Comparable<T>> implements Iterable<T> {

    private T[] pq;

    private int N;

    @SuppressWarnings("unchecked")
    MaxPQ(int capacity) {
	pq = (T[]) new Comparable[capacity + 1];
    }

    public int size() {
	return N - 1;
    }

    public T max() {
	if (N <= 1)
	    throw new NoSuchElementException();
	return pq[1];
    }

    public void add(T t) {
	pq[++N] = t;
	swim(N);
    }

    public T delMax() {
	if (N <= 1)
	    return null;
	T t = pq[1];
	pq[1] = pq[N];
	pq[N--] = null;
	sink(1);
	return t;
    }

    @Override
    public Iterator<T> iterator() {
	return new MaxPQIterator();
    }

    private class MaxPQIterator implements Iterator<T> {

	private int cursor;

	@Override
	public boolean hasNext() {
	    return cursor != pq.length - 1;
	}

	@Override
	public T next() {
	    if (!hasNext())
		return null;
	    return pq[++cursor];
	}

	@Override
	public void remove() {
	    throw new UnsupportedOperationException();
	}

    }

    private void sink(int k) {
	while (2 * k <= N) {
	    int j = 2 * k;
	    if (j < N && greater(j + 1, j))
		j = j + 1;
	    if (greater(k, j))
		break;
	    swap(k, j);
	    k = j;
	}
    }

    private void swim(int k) {
	while (k > 1) {
	    if (!greater(k, k / 2))
		break;
	    swap(k, k / 2);
	    k = k / 2;
	}
    }

    private void swap(int i, int j) {
	T t = pq[i];
	pq[i] = pq[j];
	pq[j] = t;
    }

    private boolean greater(int i, int j) {
	return pq[i].compareTo(pq[j]) > 0;
    }

    public String toString() {
	return Arrays.toString(pq);
    }

    public static void main(String[] args) {
	MaxPQ<Integer> pq = new MaxPQ<>(10);
	pq.add(4);
	pq.add(3);
	pq.add(9);
	pq.add(6);
	pq.add(1);
	pq.add(5);
	pq.add(10);
	pq.add(2);
	System.out.println(pq);

	System.out.println("size : " + pq.size());
	System.out.println("Max : " + pq.max());
	System.out.println("delMax : " + pq.delMax());
	System.out.println(pq);

	Iterator<Integer> itr = pq.iterator();
	while (itr.hasNext()) {
	    System.out.print(itr.next() + "\t");
	}

	System.out.println("\n" + pq);
	System.out.println("delMax : " + pq.delMax());
	System.out.println("\n" + pq);
	System.out.println("delMax : " + pq.delMax());
	System.out.println("\n" + pq);
	System.out.println("delMax : " + pq.delMax());
	System.out.println("\n" + pq);
	System.out.println("delMax : " + pq.delMax());
	System.out.println("\n" + pq);
	System.out.println("delMax : " + pq.delMax());
	System.out.println("\n" + pq);
	System.out.println("delMax : " + pq.delMax());
	System.out.println("\n" + pq);
	System.out.println("delMax : " + pq.delMax());
	System.out.println("\n" + pq);
	System.out.println("delMax : " + pq.delMax());
	System.out.println("\n" + pq);
	System.out.println("delMax : " + pq.delMax());
	System.out.println("\n" + pq);
	System.out.println("delMax : " + pq.delMax());
    }

}
