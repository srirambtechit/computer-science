package com.msrm.algorithms.string;

/**
 * Reverse the input word by word at odd positions in given sentence. each word
 * separated by space. Here the position counts from 0, 1, 2 and so on. Ex:
 * 
 * input : THIS IS A TESTING STRING
 * 
 * output: THIS SI A GNITSET STRING
 * 
 * @author Sriram
 *
 */

public class ReverseWordsFromSentence {

    public static void main(String[] args) {
	String input = "THIS IS A TESTING STRING";
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
	return new String(ch);
    }

    public void reverseWord(char[] word) {
	int len = word.length - 1;
	for (int i = len; i >= word.length / 2; i--) {
	    int j = len - i;
	    char t = word[i];
	    word[i] = word[j];
	    word[j] = t;
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
