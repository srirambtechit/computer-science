package com.msrm.algorithms.datastructure;

public class MySetApp {

    public static void main(String[] args) {
	MySet set = new MySet();
	System.out.println(set);
	for (int i = 1; i < 20; i++) {
	    add(set, (int) (Math.random() * 10));
	}
    }

    public static void add(MySet set, Integer data) {
	System.out.println("Adding element to MySet " + data);
	System.out.println(set.add(data));
	System.out.println(set);
	System.out.println();
    }

}
