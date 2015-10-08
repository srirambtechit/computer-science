package com.datastructure.stack;

import java.util.Iterator;

public class App {

    public static void main(String[] args) {
	StackLinkedList<Integer> s = new StackLinkedList<>();
	s.push(3);
	s.push(8);
	s.push(9);
	System.out.println(s);

	Iterator<Integer> itr = s.iterator();
	while (itr.hasNext()) {
	    System.out.println(itr.next());
	}

    }

}
