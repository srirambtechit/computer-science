package com.msrm.interview.algorithms;

import java.util.Arrays;

/**
 * <pre>
 * Save the string �WELCOMETOZOHOCORPORATION� in a two dimensional array 
 * and search for substring like �too� in the two dimensional string both 
 * from left to right and from top to bottom.
 * 
 * w	e	L	C	O
 * M	E	T	O	Z
 * O	H	O	C	O
 * R	P	O	R	A
 * T	I	O	n	  
 * 
 * And print the start and ending index as
 * 
 * Start index : <1,2>
 * 
 * End index: <3, 2>
 * </pre>
 * 
 * @author sriram
 *
 */
public class FindStringInArray {

    public static void main(String[] args) {
	char[] arr = "ABCDEFGHIJKLMN".toCharArray();
	char[][] arr2d = convertTo2DArray(arr);
	String[] strs = { "ABC", "ABCD", "ABDC", "FJN", "CG", "CGK", "AEIM", "MIE", "XYZ" };

	print2D(arr2d);
	for (String str : strs) {
	    Result result = find(arr2d, str.toCharArray());
	    if (result != null && result.found) {
		System.out.printf("string : %s", str);
		System.out.printf("; start index: <%d, %d>", result.startX, result.startY);
		System.out.printf("; End  index: <%d, %d>%n", result.endX, result.endY);
	    } else {
		System.out.println("Not found : " + str);
	    }
	}
    }

    private static void print2D(char[][] arr) {
	System.out.printf("\t");
	for (int i = 0; i < arr.length; i++)
	    System.out.printf("%d\t", i);
	System.out.println("\n");

	for (int i = 0; i < arr.length; i++) {
	    System.out.printf("%d\t", i);
	    for (int j = 0; j < arr.length; j++) {
		System.out.printf("%c\t", arr[i][j]);
	    }
	    System.out.println("\n");
	}
    }

    private static Result find(char[][] arr2d, char[] str) {

	Result result = null;
	int strIndex = 0;

	for (int i = 0; i < arr2d.length; i++) {
	    for (int j = 0; j < arr2d[i].length; j++) {
		if (arr2d[i][j] == str[strIndex]) {
		    Result leftToRightResult = scanLeftToRight(i, j + 1, strIndex + 1, arr2d, str);
		    if (leftToRightResult.found) {
			leftToRightResult.startX = i;
			leftToRightResult.startY = j;
			result = leftToRightResult;
			break;
		    } else {
			Result topToBottomResult = scanTopToBottom(i + 1, j, strIndex + 1, arr2d, str);
			if (topToBottomResult.found) {
			    topToBottomResult.startX = i;
			    topToBottomResult.startY = j;
			    result = topToBottomResult;
			    break;
			}
		    }
		}
	    }
	}

	return result;
    }

    private static Result scanTopToBottom(int row, int col, int strIndex, char[][] arr2d, char[] str) {
	Result result = new Result();
	result.found = false;
	int i = row;

	for (; i < arr2d[col].length; i++) {

	    if (strIndex == str.length) {
		result.found = true;
		break;
	    }

	    if (arr2d[i][col] != str[strIndex]) {
		break;
	    }
	    strIndex++;
	}

	if (strIndex == str.length) {
	    // every iteration, i value increments by 1 so decrement by 1
	    result.found = true;
	    result.endX = i - 1;
	    result.endY = col;
	}

	return result;
    }

    private static Result scanLeftToRight(int row, int col, int strIndex, char[][] arr2d, char[] str) {

	Result result = new Result();
	result.found = false;
	int i = col;

	for (; i < arr2d[row].length; i++) {

	    // Expected string found and done matching, so break loop
	    if (strIndex == str.length) {
		result.found = true;
		break;
	    }
	    // Expected string character not found in the first comparison
	    // itself, so stop iterating

	    if (arr2d[row][i] != str[strIndex]) {
		break;
	    }
	    strIndex++;
	}

	if (strIndex == str.length) {
	    result.found = true;
	    result.endX = row;
	    // every iteration, i value increments by 1 so decrement by 1
	    result.endY = i - 1;
	}

	return result;
    }

    private static char[][] convertTo2DArray(char[] arr) {
	int len = arr.length;

	// calculating maximum index for 2D array
	int i = 0;
	while (i * i < len) {
	    i++;
	}

	char[][] result = new char[i][i];
	int index = 0;

	for (int x = 0; x < result.length; x++) {
	    for (int y = 0; y < result[x].length; y++) {
		if (len > index) {
		    result[x][y] = arr[index++];
		}
	    }
	}
	return result;
    }

    private static class Result {
	public boolean found;
	int startX;
	int startY;
	int endX;
	int endY;
    }

}
