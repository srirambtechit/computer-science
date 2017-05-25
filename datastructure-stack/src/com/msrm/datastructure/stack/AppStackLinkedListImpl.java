package com.msrm.datastructure.stack;

import java.util.Iterator;

public class AppStackLinkedListImpl {

    public static void main(String[] args) {
	StackLinkedListImpl<Integer> s = new StackLinkedListImpl<>();
	System.out.println("Empty : " + s.isEmpty());
	s.push(3);
	s.push(8);
	s.push(9);
	System.out.println(s);
	System.out.println("Size: " + s.size());
	System.out.println("Empty : " + s.isEmpty());

	Iterator<Integer> itr = s.iterator();
	while (itr.hasNext()) {
	    System.out.println(itr.next());
	}
	System.out.println("Contains : " + s.contains(3));
	System.out.println("Contains : " + s.contains(18));

	System.out.println("Pop : " + s.pop());
	System.out.println("Pop : " + s.pop());
	System.out.println("Pop : " + s.pop());
	System.out.println("Pop : " + s.pop());
	System.out.println("Empty : " + s.isEmpty());

    }

}
