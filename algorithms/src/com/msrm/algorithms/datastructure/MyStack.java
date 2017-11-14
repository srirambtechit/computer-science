package com.msrm.algorithms.datastructure;

public class MyStack<E> {

    private int stackCapactiy = 10;
    private Object[] table = new Object[stackCapactiy];
    private int top = -1;
    private int size;

    public void push(E e) {
	if (top + 1 == stackCapactiy) {
	    System.out.println("Stack is full");
	    return;
	}
	if (top == -1) {
	    top++;
	    table[top] = e;
	} else {
	    top++;
	    table[top] = e;
	}
	size++;
    }

    public E top() {
	if (top == -1)
	    return null;
	return (E) table[top];
    }

    public E pop() {
	if (isEmpty()) {
	    System.out.println("Stack is emtpy");
	    return null;
	}
	E value = (E) table[top];
	table[top] = null;
	top--;
	size--;
	return value;
    }

    public int size() {
	return size;
    }

    public boolean isEmpty() {
	return size == 0;
    }

    public boolean isFull() {
	return size == stackCapactiy;
    }

    public String toString() {
	if (isEmpty()) {
	    return "[]";
	}
	StringBuffer buf = new StringBuffer();
	buf.append("[");
	int t = top;
	while (true) {
	    buf.append(table[t--]);
	    if (t == -1)
		break;
	    buf.append(", ");
	}
	buf.append("]");
	return buf.toString();
    }

}
