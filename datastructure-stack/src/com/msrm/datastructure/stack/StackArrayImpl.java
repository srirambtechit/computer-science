package com.msrm.datastructure.stack;

import java.util.Iterator;

public class StackArrayImpl<Item> implements Iterable<Item> {

    private Item[] stack;

    private int top;

    private int size;

    @SuppressWarnings("unchecked")
    public StackArrayImpl(int capacity) {
	stack = (Item[]) new Object[capacity];
    }

    public void push(Item i) {
	if (top == stack.length)
	    return;
	stack[top++] = i;
	size++;
    }

    public Item pop() {
	if (top == 0)
	    return null;
	top--;
	size--;
	return stack[top];
    }

    public int size() {
	return size;
    }

    public boolean isEmpty() {
	return top == 0;
    }

    public boolean contains(Item item) {
	for (int i = top - 1; i >= 0; i--) {
	    if (stack[i].equals(item))
		return true;
	}
	return false;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	for (int i = top - 1; i >= 0; i--) {
	    sb.append(stack[i]);
	    if (i != 0)
		sb.append(",");
	}
	sb.append("]");
	return sb.toString();
    }

    @Override
    public Iterator<Item> iterator() {
	return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
	int ptr = top;

	@Override
	public boolean hasNext() {
	    return ptr != 0;
	}

	@Override
	public Item next() {
	    return stack[--ptr];
	}

	@Override
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }
}
