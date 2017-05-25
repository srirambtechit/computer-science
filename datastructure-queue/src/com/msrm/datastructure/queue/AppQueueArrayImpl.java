package com.msrm.datastructure.queue;

public class AppQueueArrayImpl {

    public static void main(String[] args) {
	QueueArrayImpl<Integer> q = new QueueArrayImpl<>(5);
	q.add(5);
	q.add(8);
	q.add(1);
	q.add(43);
	q.add(-1);
	q.add(0);
	System.out.println(q);
	System.out.println("Empty? " + q.isEmpty());
	System.out.println("Full? " + q.isFull());
	System.out.println("Remove : " + q.remove());
	System.out.println(q);
	System.out.println("Remove : " + q.remove());
	System.out.println(q);
	System.out.println("Remove : " + q.remove());
	System.out.println(q);
	System.out.println("Remove : " + q.remove());
	System.out.println(q);
	System.out.println("Remove : " + q.remove());
	System.out.println(q);
	System.out.println("Remove : " + q.remove());
	System.out.println(q);
	System.out.println("Empty? " + q.isEmpty());
    }

}
