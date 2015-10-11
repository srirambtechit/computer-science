package com.datastructure.queue;

import java.util.Arrays;

public class QueueArrayImpl<Item> {

    private Item[] q;
    private int frontPtr, rearPtr;

    @SuppressWarnings("unchecked")
    public QueueArrayImpl(int c) {
	q = (Item[]) new Object[c];
	frontPtr = rearPtr = -1;
    }

    public boolean isEmpty() {
	return frontPtr == q.length - 1;
    }

    public boolean isFull() {
	return rearPtr == q.length - 1;
    }

    public void add(Item i) {
	if (isFull())
	    return;
	q[++rearPtr] = i;
    }

    public Item remove() {
	if (isEmpty())
	    return null;
	Item i = q[++frontPtr];
	q[frontPtr] = null;
	return i;
    }

    @Override
    public String toString() {
	return "QueueArrayImpl [q=" + Arrays.toString(q) + ", frontPtr=" + frontPtr + ", rearPtr=" + rearPtr + "]";
    }

}
