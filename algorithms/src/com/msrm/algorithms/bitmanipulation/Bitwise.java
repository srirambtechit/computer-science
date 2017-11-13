package com.msrm.algorithms.bitmanipulation;

public class Bitwise {

    public static void main(String[] args) {
	Bitwise bit = new Bitwise();
	int n = 0b1100111000;

	System.out.println("Turn off first set bit");
	System.out.println(n + " : " + Integer.toBinaryString(n));
	int result = bit.turnOffFirstSetBit(n);
	System.out.println(result + " : " + Integer.toBinaryString(result));

	System.out.println("\nCount no of 1s in " + n);
	int onesCount = bit.countNumOnes(n);
	System.out.println("No of 1's are " + onesCount);

	System.out.println("\nCount no of 1s in " + n);
	int zerosCount = bit.countNumZeros(n);
	System.out.println("No of 1's are " + zerosCount);

	int a = 0b11001;
	int b = 0b10110; // want convert b as a
	int bitToConvert = bit.noOfBitForNumberConvertion(a, b);
	System.out.println("\nCalculate no of bits to convert from no A to no B");
	System.out.printf("A = %d; %s%n", a, Integer.toBinaryString(a));
	System.out.printf("B = %d; %s%n", b, Integer.toBinaryString(b));
	System.out.println(bitToConvert + "bits need to be changed");

	System.out.println("\nNumber power of two");
	System.out.println(n + " is power of two? " + (bit.isPowerOfTwo(n) ? "yes" : "no"));
	n = 1024;
	System.out.println(n + " is power of two? " + (bit.isPowerOfTwo(n) ? "yes" : "no"));

	System.out.println("\nNumber power of four");
	System.out.println("256 is power of four? " + (bit.isPowerOfFour(256) ? "yes" : "no"));
	System.out.println("128 is power of four? " + (bit.isPowerOfFour(128) ? "yes" : "no"));

	System.out.println("\nGetting last three bits of an integer");
	n = 0b1101100101;
	result = bit.lastThreeBitOfN(n, 3);
	System.out.println(n + " : " + Integer.toBinaryString(n));
	System.out.println("Last 3 bits : " + result);

	System.out.println("\nFive Highest bit of number");
	n = 0b11010101;
	System.out.println(n + " : " + Integer.toBinaryString(n));
	System.out.println(n + " : " + Integer.toBinaryString(bit.hightestBitOfN(n, 8, 5)));

	System.out.println("\nCheck kth bit in N is 1");
	n = 0b11010101;
	System.out.println(n + " : " + Integer.toBinaryString(n));
	System.out.println(n + " : " + (bit.checkKthBitOne(n, 3) ? "yes" : "no"));

	System.out.println("\nSwapping numbers");
	bit.swapNumbers(a, b);

	System.out.println("\nSwap even and odd bits in N");
	System.out.println(n + " : " + Integer.toBinaryString(n));
	result = bit.swapOddEvenBits(n);
	System.out.println(result + " : " + Integer.toBinaryString(result));

    }

    public int swapOddEvenBits(int n) {
	int oddBitMask = 0xaaaaaaaa;
	int evenBitMask = 0x55555555;
	int oddBits = n & oddBitMask;
	int evenBits = n & evenBitMask;
	return (evenBits << 1) | (oddBits >> 1);
    }

    public void swapNumbers(int a, int b) {
	System.out.printf("a=%d; b=%d%n", a, b);
	a = a ^ b;
	b = a ^ b;
	a = a ^ b;
	System.out.printf("a=%d; b=%d%n", a, b);
    }

    public boolean checkKthBitOne(int n, int k) {
	return (n & (1 << (k - 1))) != 0;
    }

    /**
     * <pre>
     * &#64;param n       - number to be used
     * &#64;param intSize - size of integer type
     * &#64;param k       - no of highest bits
     * </pre>
     * 
     * @return
     */
    public int hightestBitOfN(int n, int intSize, int k) {
	int mask = (1 << k) - 1;
	n = n >>> (intSize - k);
	return n & mask;
    }

    public int lastThreeBitOfN(int n, int k) {
	int mask = (1 << k) - 1;
	return n & mask;
    }

    public boolean isPowerOfFour(int n) {
	// prerequisite: n should be power of two if n is power of four
	boolean result = isPowerOfTwo(n);
	if (result) {
	    // counter variable to hold no of 0's in the number
	    int count = 0;
	    while ((n & 1) != 1) {
		count++;
		n = n >>> 1;
	    }
	    // if count has even no of 0's, then it is power of four
	    return (count & 1) == 0;
	} else {
	    return false;
	}
    }

    public boolean isPowerOfTwo(int n) {
	// suppose n is 0, logic won't
	// work, to handle added n != 0
	return n != 0 && (n & (n - 1)) == 0;
    }

    public int noOfBitForNumberConvertion(int a, int b) {
	int xor = a ^ b;
	int count = 0;
	while (xor != 0) {
	    count = count + (xor & 1);
	    xor = xor >>> 1;
	}
	return count;
    }

    public int countNumOnes(int n) {
	int count = 0;
	while (n != 0) {
	    count = count + (n & 1);
	    n = n >>> 1;
	}
	return count;
    }

    public int countNumZeros(int n) {
	int count = 0;
	while (n != 0) {
	    count++;
	    n = n & (n - 1); // set 1 bit as 0
	}
	return count;
    }

    public int turnOffFirstSetBit(int n) {
	return n & (n - 1);
    }

}
