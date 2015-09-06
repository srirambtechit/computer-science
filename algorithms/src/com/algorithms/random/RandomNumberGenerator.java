package com.algorithms.random;

import java.util.Random;

public class RandomNumberGenerator {
    
    // 0 to Integer.MAX_VALUE -1
    private final int random = new Random().nextInt(Integer.MAX_VALUE);

    // 1532480879
    // 0
    // 1
    public RandomNumberGenerator() {
	System.out.println("Random number is " + random);
    }

    public int checkNumber(int number) {
	if (number == random)
	    return 0;
	else if (number < random)
	    return 1;
	else
	    return -1;
    }
}
