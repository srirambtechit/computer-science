package com.msrm.interview.algorithms;

/**
 * <pre>
 * Print the word with odd letters as
 * 
 * P         M
 *  R      A
 *    O  R
 *      G
 *   O    R
 *  R  
 *       A
 * P          M
 * </pre>
 * 
 * @author sriram
 *
 */
public class PrintCrossStructure {

    public static void main(String[] args) {
	char[] arr = "PROGRAMMING".toCharArray();
	crossPrint(arr);
    }

    public static void crossPrint(char[] arr) {
	int len = arr.length;
	int left = 0;
	int right = len - 1;

	outer: while (left <= right || (left > arr.length || right >= 0)) {
	    for (int i = 0; i < arr.length; i++) {
		// To optimize this program uncomment line 18, comment line 16
		// for (int i = 0; i <= right || i <= left; i++) {
		if (i == left || i == right) {
		    System.out.print(arr[i]);
		} else {
		    System.out.print(' ');
		}
	    }
	    System.out.print('\n');
	    if (left == right) {
		left++;
		right--;
		continue outer;
	    }
	    left++;
	    right--;
	}
    }

}
