package com.msrm.datastructure.stack.problems;

public class TowersOfHanoi {

	/**
	 * <pre>
	 * &#64;param n no of disks
	 * &#64;param src Source Tower
	 * &#64;param aux Intermediate Tower
	 * &#64;param dest Destination Tower
	 * </pre>
	 */
	public static void toh(int n, char src, char aux, char dest) {
		if (n > 0) {
			toh(n - 1, src, dest, aux);
			System.out.println(n + " " + src + "-" + dest);
			toh(n - 1, aux, src, dest);
		}
	}

	public static void main(String[] args) {
		toh(4, 's', 't', 'd');
	}

}