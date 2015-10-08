package com.datastructure.stack.problems;

public class TowersOfHanoi {

    /**
     * <pre>
     * @param n no of disks
     * @param src Source Tower A
     * @param aux Intermediate Tower B
     * @param dest Destination Tower C
     * </pre>
     */
    public static void toh(int n, char src, char dest, char aux) {
	if (n > 0) {
	    toh(n - 1, src, dest, aux);
	    System.out.println(n + " " + src + "-" + dest);
	    toh(n - 1, dest, aux, src);
	}
    }

    public static void main(String[] args) {
	toh(3, 'A', 'B', 'C');
    }

}
