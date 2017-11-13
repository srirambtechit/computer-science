package com.msrm.datastructure.util;

public class ArrayUtil {

	public static <T> boolean contains(T[] bag, T e) {
		for (T i : bag) {
			if (i == e)
				return true;
		}
		return false;
	}

}
