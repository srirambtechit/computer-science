package com.algorithms.strings;

/**
 * Count occurrence of "ABA" in the given input string. Input string will only
 * have A and B. should not use substring() method in String class
 * 
 * @author sriram
 *
 */
public class StringValidation {

    public static void main(String[] args) {
	String[] inputs = { "AAA", "BAB", "BAA", "ABBABABABBABABAA", "AABA", "BBABA", "BBBBAAAABAABABB", "ABABABAABABABA" };
	String searchString = "ABA";
	StringValidation strValidation = new StringValidation();

	for (String string : inputs) {
	    System.out.printf("%d occurred in %s%n", strValidation.occurrence(string, searchString), string);
	}
    }

    public int occurrence(String inputString, String searchString) {
	int count = 0;

	char[] inputCharArray = inputString.toCharArray();
	char[] searchCharArray = searchString.toCharArray();

	// loop till Length(inputString) - Length(searchString) + 1, otherwise
	// it may lead to ArrayIndexOutOfBoundsException
	for (int i = 0; i < inputCharArray.length - searchCharArray.length + 1; i++) {
	    // condition for optimization of looping
	    if (inputCharArray[i] == searchCharArray[0] && checkStr(i, inputCharArray, searchCharArray)) {
		count++;
	    }
	}
	return count;
    }

    private boolean checkStr(int startIndex, char[] inputCharArray, char[] searchCharArray) {
	int endIndex = startIndex;
	for (char c : searchCharArray) {
	    if (c == inputCharArray[endIndex]) {
		endIndex++;
	    } else {
		endIndex--;
		break;
	    }
	}
	return (endIndex - startIndex) == searchCharArray.length;
    }

}
