package com.msrm.algorithms.bitmanipulation;

public class XOR {

    /**
     * Compute XOR from 1, 2, ... n numbers
     * 
     * Time: O(1)
     * 
     * @param n
     * @return
     */
    public static int computeXOR(int n) {
	if (n % 4 == 0)
	    return n;
	if (n % 4 == 1)
	    return 1;
	if (n % 4 == 2)
	    return n + 1;

	// n % 4 == 3
	return 0;
    }

    /**
     * Sample problem but it is expensive
     * 
     * Time: O(n)
     * 
     * @param n
     * @return
     */
    public static int bruteForceComputeXOR(int n) {
	int result = 1;
	for (int i = 2; i <= n; i++) {
	    result = result ^ n;
	}
	return result;
    }

    public static void main(String[] args) {
	System.out.println(bruteForceComputeXOR(6));
	System.out.println(computeXOR(6));
    }

}
