package com.algorithms.string;

/**
 * <pre>
 * 	Reverse the input word by word at odd positions in given sentence.
 * 	each word separated by space
 * 	Ex: 
 * 	input : this is a testing string
 * 	output: this si a gnitset string
 * </pre>
 * 
 * @author Sriram
 *
 */

public class ReverseWordsFromSentence {

    public static void main(String[] args) {
	String input = "this is a testing string";
	String output = performReverse(input);

	System.out.println("input  : " + input);
	System.out.println("output : " + output);
    }

    public static String performReverse(String input) {
	ReverseWordsFromSentence obj = new ReverseWordsFromSentence();

	char[] chars = obj.covertToArray(input);

	int wordCount = obj.countWords(chars);

	char[][] words = obj.getWords(chars);

	for (int i = 0; i < wordCount; i++) {
	    if (i % 2 == 1) {
		obj.reverseWord(words[i]);
	    }
	}
	return obj.reversedString(words, input.length());
    }

    public String reversedString(char[][] words, int totalChar) {
	char[] ch = new char[totalChar];
	int index = 0;
	for (int i = 0; i < words.length; i++) {
	    for (int j = 0; j < words[i].length; j++) {
		ch[index++] = words[i][j];
	    }
	    if (index < totalChar) {
		ch[index++] = ' ';
	    }
	}
	System.out.println(ch);
	return new String(ch);
    }

    public void reverseWord(char[] word) {
	for (int start = 0, end = word.length - 1; start < end; start++, end--) {
	    char t = word[start];
	    word[start] = word[end];
	    word[end] = t;
	}
    }

    private char[] covertToArray(String input) {
	if (input == null || input.isEmpty()) {
	    throw new IllegalArgumentException("Input is not valid");
	}
	return input.trim().toCharArray();
    }

    public int countWords(char[] chars) {
	if (chars.length == 0)
	    return 0;

	int count = 0;
	for (char c : chars) {
	    if (c == ' ')
		count++;
	}
	return count + 1;
    }

    public char[][] getWords(char[] chars) {
	int wordCount = countWords(chars);
	char[][] words = new char[wordCount][];

	int wordIndex = 0;

	for (int i = 0; i < chars.length;) {

	    // count chars in a word
	    int charCount = 0;
	    for (int j = i; j < chars.length && chars[j] != ' '; j++) {
		charCount++;
	    }

	    // fill the word in char array
	    words[wordIndex] = new char[charCount];
	    int k = 0;
	    int charIndex = i;
	    for (; charIndex < chars.length && chars[charIndex] != ' '; charIndex++, k++) {
		words[wordIndex][k] = chars[charIndex];
	    }

	    // one word identified
	    wordIndex++;

	    // assign next words index
	    if (charIndex < chars.length && chars[charIndex] == ' ')
		charIndex++;

	    i = charIndex;

	}

	return words;
    }

}
