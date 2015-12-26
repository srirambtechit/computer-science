package com.datastructure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Key> {

    private int maxN;

    private Key[] keys;

    // Array holds key's index into heap position
    // where i = heapPosition, hp[i] = keys array index
    private int[] hp;

    // Array holds heap position's index
    // where i = key's index, p[i] = heapPosition value
    private int[] p;

    private int N;

    @SuppressWarnings("unchecked")
    public IndexMinPQ(int n) {
	maxN = n;
	keys = (Key[]) new Comparable[n + 1];
	hp = new int[n + 1];
	p = new int[n + 1];
	for (int i = 0; i <= n; i++) {
	    p[i] = -1;
	}
    }

    public void insert(int k, Key key) {
	if (k < 0 || k >= maxN)
	    throw new IndexOutOfBoundsException();
	if (contains(k))
	    throw new IllegalArgumentException("index is already in the priority queue");
	N++;
	keys[k] = key;
	hp[N] = k;
	p[k] = N;
	swim(N);
    }

    public void decreaseKey(int i, Key key) {
	if (i < 0 || i >= maxN)
	    throw new IndexOutOfBoundsException();
	if (!contains(i))
	    throw new NoSuchElementException("index is not in the priority queue");
	if (keys[i].compareTo(key) <= 0)
	    throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
	keys[i] = key;
	swim(p[i]);
    }

    public void increaseKey(int i, Key key) {
	if (i < 0 || i >= maxN)
	    throw new IndexOutOfBoundsException();
	if (!contains(i))
	    throw new NoSuchElementException("index is not in the priority queue");
	if (keys[i].compareTo(key) >= 0)
	    throw new IllegalArgumentException("Calling increaseKey() with given argument would not strictly increase the key");
	keys[i] = key;
	sink(p[i]);
    }

    public boolean contains(int k) {
	return p[k] != -1;
    }

    public Key delMin() {
	if (N == 0)
	    throw new NoSuchElementException("Priority queue underflow");
	int min = hp[1];
	swap(1, N--);
	sink(1);
	p[min] = -1;
	hp[N + 1] = 0;
	Key k = keys[min];
	keys[min] = null;
	return k;
    }

    public Key keyIndexOf(int k) {
	if (k < 0 || k >= maxN)
	    throw new IndexOutOfBoundsException();
	if (!contains(k))
	    throw new NoSuchElementException("index is not in the priority queue");
	return keys[k];
    }

    public Key minKey() {
	if (N == 0)
	    throw new NoSuchElementException("Priority queue underflow");
	return keys[hp[1]];
    }

    public int minIndex() {
	if (N == 0)
	    throw new NoSuchElementException("Priority queue underflow");
	return hp[1];
    }

    public void changeKey(int i, Key key) {
	if (i < 0 || i >= maxN)
	    throw new IndexOutOfBoundsException();
	if (!contains(i))
	    throw new NoSuchElementException("index is not in the priority queue");
	keys[i] = key;
	swim(p[i]);
	sink(p[i]);
    }

    public void delete(int i) {
	if (i < 0 || i >= maxN)
	    throw new IndexOutOfBoundsException();
	if (!contains(i))
	    throw new NoSuchElementException("index is not in the priority queue");
	int index = p[i];
	swap(index, N--);
	swim(index);
	sink(index);
	keys[i] = null;
	p[i] = -1;
    }

    public boolean isEmpty() {
	return N == 0;
    }

    public int size() {
	return N;
    }

    private void swim(int k) {
	while (k > 1 && less(k, k / 2)) {
	    swap(k, k / 2);
	    k = k / 2;
	}
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

    private boolean less(int i, int j) {
	return keys[hp[i]].compareTo(keys[hp[j]]) < 0;
    }

    private void swap(int i, int j) {
	int t = hp[i];
	hp[i] = hp[j];
	hp[j] = t;
	p[hp[i]] = i;
	p[hp[j]] = j;
    }

    @Override
    public Iterator<Key> iterator() {
	return new IndexMinPQIterator();
    }

    private class IndexMinPQIterator implements Iterator<Key> {

	// create a new pq
	private IndexMinPQ<Key> copy;

	// add all elements to copy of heap
	// takes linear time since already in heap order so no keys move
	public IndexMinPQIterator() {
	    copy = new IndexMinPQ<Key>(hp.length - 1);
	    for (int i = 1; i <= N; i++)
		copy.insert(hp[i], keys[hp[i]]);
	}

	public boolean hasNext() {
	    return !copy.isEmpty();
	}

	public void remove() {
	    throw new UnsupportedOperationException();
	}

	public Key next() {
	    if (!hasNext())
		throw new NoSuchElementException();
	    return copy.delMin();
	}
    }

    public String toString() {
	return String.format("PQ--> %nKeys: %s%nHP  : %s%nP   : %s%n%n", Arrays.toString(keys), Arrays.toString(hp), Arrays.toString(p));
    }

    public static void main(String[] args) {
	IndexMinPQ<Character> pq = new IndexMinPQ<>(10);
	System.out.println(pq);
	Character[] ch = { 'S', 'O', 'R', 'T', 'I', 'G', 'A', 'N' };
	for (int i = 0; i < ch.length; i++) {
	    pq.insert(i, ch[i]);
	    System.out.println(pq);
	}

	 System.out.println();
	 System.out.println(pq.delMin());

	System.out.println(pq.minIndex());
	System.out.println(pq.minKey());

	pq.decreaseKey(3, 'P');
	
	System.out.println(pq);
    }

}
