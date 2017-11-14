package com.msrm.algorithms.datastructure;

public class MyNewMinStackApp {

    public static void main(String[] args) {
	MyNewMinStack<Integer> stack1 = new MyNewMinStack<>();
	System.out.println(stack1);
	for (int i = 0; i < 13; i++) {
	    add(stack1, (int) (Math.random() * 100));
	}

	add(stack1, 2);

	System.out.println(stack1);
	for (int i = 0; i < 13; i++) {
	    remove(stack1);
	}
    }

    public static void add(MyNewMinStack<Integer> stack, Integer data) {
	System.out.println("Adding element to MyNewMinStack " + data);
	stack.push(data);
	System.out.printf("%s; min: %d%n", stack, stack.min());
	System.out.println();
    }

    public static void remove(MyNewMinStack<Integer> stack) {
	System.out.println("Removing element from MyNewMinStack " + stack.pop());
	System.out.printf("%s; min: %d%n", stack, stack.min());
	System.out.println();
    }

}
