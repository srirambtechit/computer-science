package com.algorithms.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUniqueNumberGenerator {

    static int size = 10;

    public static void main(String[] args) {
	for (int i = 0; i < size; i++) {
	    System.out.printf("%4d", RandomUniqueInts.uniqueRandom());
	}
    }

    private static class RandomUniqueInts {

	static List<Integer> list = new ArrayList<>();

	static {
	    for (int i = 0; i < size; i++) {
		list.add(i);
	    }
	}

	public static int uniqueRandom() {
	    int randomIndex = new Random().nextInt(list.size());
	    return list.remove(randomIndex);
	}
    }

}
