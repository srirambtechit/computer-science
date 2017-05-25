package com.msrm.algorithms.bitmanipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StringPowerSet {

    public static void main(String[] args) {
	String set = "dcba";
	List<String> powset = powerSet(set);

	Map<Integer, List<List<String>>> map = new HashMap<>();
	int key = 1;

	for (int i = 1, j = powset.size() - 2; i < powset.size() && j > 0; i++, j--) {
	    List<List<String>> pList = new ArrayList<>();
	    List<String> list = new ArrayList<>();
	    list.add(powset.get(i));
	    list.add(powset.get(j));
	    pList.add(list);
	    map.put(key, pList);
	    key++;
	}

	for (Entry<Integer, List<List<String>>> i : map.entrySet()) {
	    System.out.println(i.getKey() + " : " + i.getValue());
	}
	System.out.println(powset);
    }

    public static List<String> powerSet(String set) {
	if (set == null || set.trim().isEmpty())
	    return null;

	StringBuilder bit = new StringBuilder();
	for (int i = 0; i < set.length(); i++) {
	    bit.append("1");
	}

	String bits = bit.toString();
	List<String> result = new ArrayList<>();

	for (int i = Integer.parseInt(bits, 2), bitLen; i >= 0; i--) {
	    bits = Integer.toString(i, 2);
	    bitLen = bits.length();
	    String subset = "";
	    for (int k = bitLen - 1; k >= 0; k--) {
		if (bits.charAt(k) == '1') {
		    subset += set.charAt(set.length() - 1 - (bits.length() - 1 - k));
		}
	    }
	    result.add(subset);
	}

	return result;
    }

}
