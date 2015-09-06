package com.algorithms.datastructure;

public class MyApp {

    public static void main(String[] args) {
	MySet set = new MySet();
	System.out.println(set);
	for (int i = 120; i < 150; i++) {
	    add(set, i);
	}
	for (int i = 120; i < 150; i++) {
	    add(set, i);
	}

	MyMinStack stack = new MyMinStack();
	System.out.println(stack);
	for (int i = 0; i < 13; i++) {
	    add(stack, (int) (Math.random() * 100));
	}

	for (int i = 0; i < 13; i++) {
	    remove(stack);
	}

	{
	    MyStack<Integer> stack1 = new MyStack<>();
	    System.out.println(stack1);
	    for (int i = 0; i < 13; i++) {
		add(stack1, (int) (Math.random() * 100));
	    }

	    for (int i = 0; i < 13; i++) {
		remove(stack);
	    }
	}

	{
	    MyNewMinStack<Integer> stack1 = new MyNewMinStack<>();
	    System.out.println(stack1);
	    for (int i = 0; i < 13; i++) {
		add(stack1, (int) (Math.random() * 100));
	    }

	    System.out.println(stack1);
	    for (int i = 0; i < 13; i++) {
		remove(stack1);
	    }
	}
    }

    public static void remove(MyNewMinStack<Integer> stack) {
	System.out.println("Removing element from MyNewMinStack " + stack.pop());
	System.out.printf("%s; min: %d%n", stack, stack.min());
	System.out.println();
    }

    public static void add(MyNewMinStack<Integer> stack, Integer data) {
	System.out.println("Adding element to MyNewMinStack " + data);
	stack.push(data);
	System.out.printf("%s; min: %d%n", stack, stack.min());
	System.out.println();
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
	System.out.printf("%s; min: %d%n", stack, stack.getMinimum());
	System.out.println();
    }

    public static void add(MyMinStack stack, Integer data) {
	System.out.println("Adding element to MyMinStack " + data);
	stack.push(data);
	System.out.printf("%s; min: %d%n", stack, stack.getMinimum());
	System.out.println();
    }

    public static void add(MySet set, Integer data) {
	System.out.println("Adding element to MySet " + data);
	System.out.println(set.add(data));
	System.out.println(set);
	System.out.println();
    }

}
