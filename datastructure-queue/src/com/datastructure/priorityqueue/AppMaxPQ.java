package com.datastructure.priorityqueue;

import java.util.Iterator;

public class AppMaxPQ {

    public static void main(String[] args) {
	MaxPQ<Integer> pq = new MaxPQ<>(10);
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
	pq.delMax();
	System.out.println(pq);

	Iterator<Integer> itr = pq.iterator();
	while (itr.hasNext()) {
	    System.out.println("Data : " + itr.next());
	}
    }

}
