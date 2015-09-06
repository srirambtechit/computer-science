package com.techgig.programs;

public class CountWordInMatrix {

    public static void main(String[] args) {
	wordCount(3, new String[] { "A#A#K", "A#S#K", "A#K#K" }, "ASK");
	wordCount(3, new String[] { "A#A#K", "A#S#K", "A#K#K" }, "KMZ");
    }

    public static int wordCount(int size, String[] data, String searchWord) {
	System.out.println("\nInput string is " + searchWord);
	if (searchWord.length() != size) {
	    System.out.println("Occured at 0 times");
	    return 0;
	}

	int count = 0;

	// 1. Constructing matrix from given string array
	int row = size;
	int col = size;
	char[][] matrix = new char[row][col];
	for (int i = 0; i < size; i++) {
	    String[] strs = data[i].split("#");
	    for (int j = 0; j < strs.length; j++) {
		matrix[i][j] = strs[j].charAt(0);
	    }
	}

	// 2. scan from left to right each row
	int matchCharCount = 0;
	for (int i = 0; i < row; i++) {
	    for (int j = 0; j < col; j++) {
		if (matrix[i][j] != searchWord.charAt(j)) {
		    break;
		}
		matchCharCount++;
	    }
	    if (matchCharCount == size) {
		System.out.println("scan from left to right each row");
		count++;
	    }
	    matchCharCount = 0;
	}

	// 3. scan from top to bottom each column
	matchCharCount = 0;
	for (int i = 0; i < row; i++) {
	    for (int j = 0; j < col; j++) {
		if (matrix[j][i] != searchWord.charAt(j)) {
		    break;
		}
		matchCharCount++;
	    }
	    if (matchCharCount == size) {
		System.out.println("scan from top to bottom each column");
		count++;
	    }
	    matchCharCount = 0;
	}

	// 4. scan from leftTop to rightBottom - diagonally downwards
	matchCharCount = 0;
	for (int i = 0; i < row; i++) {
	    if (matrix[i][i] != searchWord.charAt(i)) {
		break;
	    }
	    matchCharCount++;
	}
	if (matchCharCount == size) {
	    System.out.println("scan from leftTop to rightBottom - diagonally downwards");
	    count++;
	}

	// 4. scan from rightTop to leftBottom - diagonally downwards
	matchCharCount = 0;
	for (int i = 0, j = col - 1; i < row && j < col; i++, j--) {
	    if (matrix[i][j] != searchWord.charAt(i)) {
		break;
	    }
	    matchCharCount++;
	}
	if (matchCharCount == size) {
	    System.out.println("scan from rightTop to leftBottom - diagonally downwards");
	    count++;
	}

	// 5. scan from leftBottom to rightTop - diagonally upwards
	matchCharCount = 0;
	for (int i = row - 1, j = 0; i < row && j < col; i--, j++) {
	    if (matrix[i][j] != searchWord.charAt(j)) {
		break;
	    }
	    matchCharCount++;
	}
	if (matchCharCount == size) {
	    System.out.println("scan from leftBottom to rightTop - diagonally upwards");
	    count++;
	}

	// 6. scan from rightBottom to leftTop - diagonally upwards
	matchCharCount = 0;
	for (int i = row - 1, j = col - 1, charIndex = 0; i < row && j < col; i--, j--, charIndex++) {
	    if (matrix[i][j] != searchWord.charAt(charIndex))
		break;
	    matchCharCount++;
	}
	if (matchCharCount == size) {
	    System.out.println("scan from rightBottom to leftTop - diagonally upwards");
	    count++;
	}

	System.out.printf("Occurred at %d times%n", count);

	return count;
    }

}
