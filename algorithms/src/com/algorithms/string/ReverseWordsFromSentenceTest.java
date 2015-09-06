package com.algorithms.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseWordsFromSentenceTest {

    ReverseWordsFromSentence obj = new ReverseWordsFromSentence();

    @Test
    public void testCountWords() {
	String input = "test";
	assertEquals(1, obj.countWords(converInput(input)));

	input = "test string";
	assertEquals(2, obj.countWords(converInput(input)));

	input = "";
	assertEquals(0, obj.countWords(converInput(input)));
    }

    private char[] converInput(String input) {
	return input.trim().toCharArray();
    }

}
