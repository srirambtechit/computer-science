package com.msrm.datastructure.symboltable.st;

public class AppST {

	public static void main(String[] args) {
		STListImpl<Integer, String> st = new STListImpl<>(5);
		st.put(1, "one");
		st.put(2, "two");
		st.put(3, "three");
		st.put(4, "four");
		st.put(5, "five");
		st.put(6, "six");
		st.put(7, "seven");
		st.put(8, "eight");
		st.put(12, "twelve");
		System.out.println(st);
		System.out.println(st.containsKey(7));
		System.out.println(st.containsKey(12));

		st.remove(7);
		System.out.println(st);
		System.out.println(st.containsKey(7));

		st.remove(12);
		System.out.println(st);
		System.out.println(st.containsKey(12));

		st.put(12, "Number12");
		System.out.println(st);
		System.out.println(st.containsKey(12));

		System.out.println(st.containsValue("seven"));
		System.out.println(st.containsValue("three"));
	}

}
