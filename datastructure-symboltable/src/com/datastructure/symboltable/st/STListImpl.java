package com.datastructure.symboltable.st;

import java.util.Arrays;

/**
 * SymbolTable implemented in Linked node structure
 * 
 * @author sriram
 *
 */
public class STListImpl<K, V> {

    private Object[] st;

    private int capacity;

    public STListImpl(int c) {
	st = new Object[c];
	this.capacity = c;
    }

    @SuppressWarnings("unchecked")
    public void put(K k, V v) {
	if (k == null || v == null)
	    return;
	int i = hash(k);
	Node p = (Node) st[i];
	for (; p != null; p = p.next) {
	    if (p.key.equals(k)) {
		p.value = v;
		return;
	    } else if (p.next == null) {
		p.next = new Node(k, v);
		return;
	    }
	}
	st[i] = new Node(k, v);
    }

    public int hash(Object k) {
	return (k.hashCode() & 0x7fffffff) % capacity;
    }

    private class Node {
	private K key;
	private V value;
	private Node next;

	private Node(K key, V value) {
	    this.key = key;
	    this.value = value;
	}

	@Override
	public String toString() {

	    StringBuffer buf = new StringBuffer();
	    buf.append("Node [key=").append(key).append(", value=").append(value).append(" next = [");
	    for (Node n = next; n != null; n = n.next) {
		buf.append("Node [key=").append(n.key).append(", value=").append(n.value).append("]");
		if (n.next != null)
		    buf.append(",");
	    }
	    buf.append("]");
	    return buf.toString();
	}

    }

    @Override
    public String toString() {
	return "ST [st=" + Arrays.toString(st) + ", capacity=" + capacity + "]";
    }

}
