package com.msrm.algorithms.datastructure;

public class MyMinStackApp {

    public static void main(String[] args) {

	MyMinStack stack = new MyMinStack();
	System.out.println(stack);
	for (int i = 0; i < 13; i++) {
	    add(stack, (int) (Math.random() * 100));
	}

	for (int i = 0; i < 13; i++) {
	    remove(stack);
	}

	MyStack<Integer> stack1 = new MyStack<>();
	System.out.println(stack1);
	for (int i = 0; i < 13; i++) {
	    add(stack1, (int) (Math.random() * 100));
	}

	for (int i = 0; i < 13; i++) {
	    remove(stack);
	}

    }

    public static void remove(MyStack<Integer> stack) {
	System.out.println("Removing element from MyStack " + stack.pop());
	System.out.printf("%s; %n", stack);
	System.out.println();
    }

    public static void add(MyStack<Integer> stack, Integer data) {
	System.out.println("Adding element to MyStack " + data);
	stack.push(data);
	System.out.printf("%s; %n", stack);
	System.out.println();
    }

    public static void remove(MyMinStack stack) {
	System.out.println("Removing element from MyMinStack " + stack.pop());
	System.out.printf("%s; min: %d%n", stack, stack.min());
	System.out.println();
    }

    public static void add(MyMinStack stack, Integer data) {
	System.out.println("Adding element to MyMinStack " + data);
	stack.push(data);
	System.out.printf("%s; min: %d%n", stack, stack.min());
	System.out.println();
    }

}
