package com.interview.algorithms;

import java.util.Arrays;

/**
 * <pre>
 * Given a set of numbers like <10, 36, 54,89,12> we want to find sum of weights based on the 
 * following conditions
 *     1. 5 if a perfect square
 *     2. 4 if multiple of 4 and divisible by 6
 *     3. 3 if even number
 * 
 * And sort the numbers based on the weight and print it as follows
 * 
 * <10,its_weight>,<36,its weight><89,its weight>
 * 
 * Should display the numbers based on increasing order.
 * </pre>
 * 
 * @author sriram
 *
 */
public class NumbersAndWeights {

    public static void main(String[] args) {
	int[] arr = { 15, 36, 54, 89, 10 };
	Element[] elements = new Element[arr.length];

	for (int i = 0; i < arr.length; i++) {
	    elements[i] = new Element(arr[i]);
	}

	System.out.println(Arrays.toString(elements));

	Arrays.sort(elements);

	System.out.println(Arrays.toString(elements));
    }

    private static class Element implements Comparable<Element> {
	private int value;
	private int weight;

	public Element(int value) {
	    this.value = value;
	    perfectSquareCheck();
	    mulAndDivCheck();
	    evenNumberCheck();
	}

	private void perfectSquareCheck() {
	    int val = (int) Math.sqrt(value);
	    if (val * val == value) {
		this.weight += 5;
	    }
	}

	private void mulAndDivCheck() {
	    if (value % 4 == 0 && value % 6 == 0) {
		this.weight += 4;
	    }
	}

	private void evenNumberCheck() {
	    if (value % 2 == 0) {
		this.weight += 3;
	    }
	}

	@Override
	public String toString() {
	    return "(" + value + "," + weight + ")";
	}

	@Override
	public int compareTo(Element element) {
	    if (this.weight > element.weight)
		return 1;
	    else if (this.weight < element.weight)
		return -1;
	    else {
		if (this.weight == element.weight) {
		    if (this.value > element.value)
			return 1;
		    else if (this.value < element.value)
			return -1;
		    else
			return 0;
		}
	    }
	    return 0;
	}
    }

}
