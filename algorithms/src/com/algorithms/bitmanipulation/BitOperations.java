package com.algorithms.bitmanipulation;

public class BitOperations {

    public static void main(String[] args) {
	System.out.println(bitOffAt(0b1101, 1));
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
    public static int bitOffAt(int number, int bitPosition) {
	return number & ~(1 << (bitPosition - 1));
    }

}
