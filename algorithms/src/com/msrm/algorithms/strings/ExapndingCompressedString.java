package com.msrm.algorithms.strings;

/**
 * A compressed string is stored in an array of sufficient length. Write a
 * program and its complexity to uncompress the string. i.e. a3b6c4 which
 * uncompressed as aaabbbbbbcccc
 * 
 * @author sriram
 *
 */
public class ExapndingCompressedString {

    public static void main(String[] args) {
	ExapndingCompressedString obj = new ExapndingCompressedString();
	String str = "140812";
	System.out.println(obj.validateInput(str));
	System.out.println(obj.calculateSize(str));

	if (obj.validateInput(str)) {
	    String output = obj.decompress(str);
	    System.out.println("compressed str : " + str);
	    System.out.println("decompressed str : " + output);
	} else {
	    System.out.printf("Wrong string input [%s]", str);
	}
    }

    public String decompress(String str) {
	char[] chs = new char[calculateSize(str)];
	int chIndex = 0;

	for (int index = 0; index < str.length(); index += 2) {
	    char c = str.charAt(index);
	    int count = Integer.parseInt(String.valueOf(str.charAt(index + 1)));
	    while (count > 0) {
		chs[chIndex] = c;
		chIndex++;
		count--;
	    }
	}

	return new String(chs);
    }

    private int calculateSize(String str) {
	int size = 0;
	for (int index = 1; index < str.length(); index += 2) {
	    size += Integer.parseInt(String.valueOf(str.charAt(index)));
	}
	return size;
    }

    public boolean validateInput(String str) {
	if (str == null || str.trim().length() == 0) {
	    return false;
	}
	// string length should be even number
	if ((str.length() & 1) != 0) {
	    return false;
	}

	try {
	    for (int index = 1; index < str.length(); index += 2) {
		Integer.parseInt(String.valueOf(str.charAt(index)));
	    }
	} catch (NumberFormatException e) {
	    return false;
	}
	return true;
    }

}
