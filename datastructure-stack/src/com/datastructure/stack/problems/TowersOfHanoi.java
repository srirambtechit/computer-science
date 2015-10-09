package com.datastructure.stack.problems;

public class TowersOfHanoi {

    /**
     * <pre>
     * @param n no of disks
     * @param src Source Tower
     * @param aux Intermediate Tower
     * @param dest Destination Tower
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
	toh(3, 'A', 'B', 'C');
    }

}