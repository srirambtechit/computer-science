package com.datastructure.symboltable.st;

import java.util.Arrays;

/**
 * <pre>
 * SymbolTable implemented in Linked node structure
 * 
 * Operation:-
 * 	- put(K, V) - for adding/updating
 * 	- remove(K) - Removing Value based on Key		
 * 	- contains(K) - checking Key exists in ST
 * 	- contains(V) - checking Value exists in ST
 * 	- size() - Number of elements in ST
 * </pre>
 * 
 * @author sriram
 *
 */
public class STListImpl<K, V> {

    private Object[] st;

    private int capacity;

    private int size;

    public STListImpl(int c) {
	st = new Object[c];
	this.capacity = c;
    }

    public int size() {
	return size;
    }

    public void put(K k, V v) {
	if (k == null || v == null)
	    return;
	size++;
	int i = hash(k);
	Node p = getNode(i);
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

    public V remove(K k) {
	if (k == null)
	    return null;
	int i = hash(k);
	for (Node p = getNode(i); p != null; p = p.next) {
	    if (p.key.equals(k)) {
		V v = p.value;
		if (p.next != null) {
		    p.key = p.next.key;
		    p.value = p.next.value;
		    p.next = p.next.next;
		} else {
		    p.value = null;
		}
		size--;
		return v;
	    }
	}
	return null;
    }

    // Time - O(n)
    public boolean containsKey(K k) {
	int i = hash(k);
	for (Node p = getNode(i); p != null; p = p.next) {
	    if (p.key.equals(k) && p.value != null) {
		return true;
	    }
	}
	return false;
    }

    // Time - O(n^2)
    public boolean containsValue(V v) {
	for (int i = 0; i < capacity; i++) {
	    for (Node p = getNode(i); p != null; p = p.next) {
		if (p.value.equals(v)) {
		    return true;
		}
	    }
	}
	return false;
    }

    @SuppressWarnings("unchecked")
    private Node getNode(int i) {
	return (Node) st[i];
    }

    private int hash(Object k) {
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
