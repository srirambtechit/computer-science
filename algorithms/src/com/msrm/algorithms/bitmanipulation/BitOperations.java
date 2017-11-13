package com.msrm.algorithms.bitmanipulation;

public class BitOperations {

    public static void main(String[] args) {
	int number = 0b11101;
	int bitPosition = 3;
	System.out.println("Input : " + Integer.toBinaryString(number));
	System.out.println("Off   : " + Integer.toBinaryString(offBitAt(number, bitPosition)));
	System.out.println("On    : " + Integer.toBinaryString(onBitAt(number, bitPosition)));
    }

    /**
     * <pre>
     * make particular bit to OFF in the given number
     * Ex:
     * 1101 off at 3rd position, so 1001
     * </pre>
     * 
     * @param number
     *            - Input number
     * @param bitPosition
     *            - starts at 0
     * @return
     */
    public static int offBitAt(int number, int bitPosition) {
	return number & ~(1 << (bitPosition - 1));
    }

    public static int onBitAt(int number, int bitPosition) {
	return number | (1 << (bitPosition - 1));
    }

}
