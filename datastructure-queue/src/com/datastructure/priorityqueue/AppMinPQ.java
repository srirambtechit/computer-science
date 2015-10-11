package com.datastructure.priorityqueue;

import java.util.Iterator;

public class AppMinPQ {

    public static void main(String[] args) {
	MinPQ<Integer> pq = new MinPQ<>(10);
	System.out.println(pq);
	System.out.println("Size : " + pq.size());
	pq.add(4);
	pq.add(3);
	pq.add(5);
	pq.add(1);
	pq.add(8);
	pq.add(9);
	pq.add(37);
	pq.add(34);
	pq.add(49);
	System.out.println(pq);
	System.out.println("Size : " + pq.size());
	pq.delMin();
	System.out.println(pq);

	Iterator<Integer> itr = pq.iterator();
	while (itr.hasNext()) {
	    System.out.println("Data : " + itr.next());
	}
    }

}
