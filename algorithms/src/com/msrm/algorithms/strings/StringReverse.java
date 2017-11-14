package com.msrm.algorithms.strings;

public class StringReverse {

    public static void main(String[] args) {
	String str = "sriram";
	System.out.println("input : " + str);

	StringReverse sr = new StringReverse();

	System.out.println("\nIterative");
	System.out.println(sr.reverseIterative(str));

	System.out.println("\nRecursive");
	System.out.println(sr.reverseRecursive(str));
    }

    public String reverseIterative(String str) {
	char[] arr = str.toCharArray();
	if (arr == null)
	    return "";
	int first = 0;
	int last = arr.length - 1;
	for (; first < last;) {
	    swap(arr, first, last);
	    first++;
	    last--;
	}
	return new String(arr);
    }

    public String reverseRecursive(String str) {
	char[] arr = str.toCharArray();
	return new String(recursive(arr, -1, str.length()));
    }

    private char[] recursive(char[] arr, int left, int right) {
	if (left > right) {
	    swap(arr, left, right);
	    return arr;
	}
	left++;
	right--;
	swap(arr, left, right);
	return recursive(arr, left, right);
    }

    private void swap(char[] arr, int first, int last) {
	char c = arr[first];
	arr[first] = arr[last];
	arr[last] = c;
    }
}
