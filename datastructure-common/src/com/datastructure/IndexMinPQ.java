package com.datastructure;

import java.util.Iterator;

public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Key> {

    private Key[] keys;
    private int[] hp;
    private int[] r;
    private int N;

    @SuppressWarnings("unchecked")
    public IndexMinPQ(int n) {
	keys = (Key[]) new Comparable[n];
	hp = new int[n];
	r = new int[n + 1];
    }

    public void insert(int i, Key key) {

    }

    public void decreaseKey(int i, Key key) {

    }

    public boolean contains(int i) {
	return false;
    }

    public int delMin() {
	return -1;
    }

    public boolean isEmpty() {
	return false;
    }

    public int size() {
	return N;
    }

    private boolean less(int i, int j) {
	return keys[i].compareTo(keys[j]) < 0;
    }

    private void swap(int i, int j) {
	Key k = keys[i];
	keys[i] = keys[j];
	keys[j] = k;
    }

    @Override
    public Iterator<Key> iterator() {
	// TODO Auto-generated method stub
	return null;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
