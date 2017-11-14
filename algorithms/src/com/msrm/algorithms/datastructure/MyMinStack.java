package com.msrm.algorithms.datastructure;

public class MyMinStack {
    private int stackCapactiy = 10;
    private Entry[] table = new Entry[stackCapactiy];
    private int top = -1;
    private int size;

    public int size() {
	return size;
    }

    public void push(Integer value) {
	if (top + 1 == stackCapactiy) {
	    System.out.println("Stack is full");
	    return;
	}
	if (top == -1) {
	    top++;
	    Entry e = new Entry(value, value);
	    table[top] = e;
	} else {
	    Entry e = table[top];
	    int min = Math.min(value, e.min);
	    Entry newEntry = new Entry(value, min);
	    top++;
	    table[top] = newEntry;
	}
	size++;
    }

    public Integer pop() {
	if (isEmpty()) {
	    System.out.println("Stack is emtpy");
	    return null;
	}
	Integer value = table[top].data;
	table[top] = null;
	top--;
	size--;
	return value;
    }

    public Integer min() {
	if (isEmpty()) {
	    return null;
	}
	return table[top].min;
    }

    private class Entry {
	private Integer data;
	private Integer min;

	private Entry(Integer data, Integer min) {
	    this.data = data;
	    this.min = min;
	}
    }

    public boolean isEmpty() {
	return size == 0;
    }

    public String toString() {
	if (isEmpty()) {
	    return "[]";
	}
	StringBuffer buf = new StringBuffer();
	buf.append("[");
	int t = top;
	while (t != -1) {
	    buf.append(table[t].data);
	    t--;
	    if (t != -1) {
		buf.append(", ");
	    }
	}
	buf.append("]");
	return buf.toString();
    }
}
