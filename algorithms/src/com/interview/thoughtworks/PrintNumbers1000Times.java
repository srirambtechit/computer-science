package com.interview.thoughtworks;

/**
 * Print numbers from 1 to 1000 without using any looping statements, recursive
 * methods call
 * 
 * @author Sriram
 *
 */
public class PrintNumbers1000Times {

    public PrintNumbers1000Times(int n) {
	System.out.println(n);
	if (n != 1000) {
	    PrintNumbers1000Times obj = new PrintNumbers1000Times(++n);
	    obj = null;
	}
    }

    public static void main(String[] args) {
	new PrintNumbers1000Times(1);
    }

}
