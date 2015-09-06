package com.algorithms.datastructure;

public class MyNewMinStack<E extends Comparable<E>> extends MyStack<E> {

    private MyStack<E> minStack = new MyStack<>();

    @Override
    public void push(E e) {
	if (min() == null) {
	    minStack.push(e);
	} else if (e.compareTo(min()) <= 0) {
	    minStack.push(e);
	}
	super.push(e);
    }

    public E min() {
	if (minStack.isEmpty()) {
	    return null;
	} else {
	    return minStack.top();
	}
    }

    @Override
    public E pop() {
	E e = super.pop();
	super.top();
	if (e == minStack.top()) {
	    minStack.pop();
	}
	return e;
    }

}
