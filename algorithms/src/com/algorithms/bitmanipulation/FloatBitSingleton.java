package com.algorithms.bitmanipulation;

public class FloatBitSingleton {

    public static void main(String[] args) {
	float[] floats = { 1.2f, 7.340f, 2.3f, 3.34f, 7.340f, 4.567f, 5.65f, 6.234f, 7.340f, 4.567f, 7.340f, 2.3f, 6.234f, 7.340f, 3.34f, 1.2f, 5.65f };
	float number = findFloatBitSingleton(floats);
	System.out.println("Odd number : " + number);
    }

    public static float findFloatBitSingleton(float[] floats) {
	int intBits = Float.floatToIntBits(floats[0]);
	for (int i = 0; i < floats.length; i++) {
	    intBits ^= Float.floatToIntBits(floats[i]);
	}
	return Float.intBitsToFloat(intBits);
    }

}
