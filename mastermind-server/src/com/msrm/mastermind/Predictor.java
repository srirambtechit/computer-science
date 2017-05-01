package com.msrm.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Predictor {

	private Checker2 checker;
	private int[] redundantNums;
	private int[] predictedDigits;

	public Predictor(int serverNumber) {
		int length = String.valueOf(serverNumber).length();
		this.checker = new Checker2(serverNumber);

		this.redundantNums = new int[10];
		for (int i = 0; i < 10; i++) {
			redundantNums[i] = formRedundantDigitNumber(i, length);
		}

		this.predictedDigits = new int[length];
	}

	private int formRedundantDigitNumber(int n, int noOfDigits) {
		int i = 1;
		int sum = n;
		while (i != noOfDigits) {
			sum = sum * 10 + n;
			i++;
		}
		return sum;
	}

	public int predict() {
		int pos = 0;
		for (int i = 0; i < 10; i++) {
			Result result = checker.check(redundantNums[i]);
			int count = result.getPositionAndValueCount();
			while (count-- != 0) {
				predictedDigits[pos++] = i;
			}
		}
		System.out.println(Arrays.toString(predictedDigits));

		List<Integer> list = new ArrayList<>();
		permute(predictedDigits, 0, predictedDigits.length - 1, list);

		for (Integer ints : list) {
			Result result = checker.check(ints);
			if (result.getPoints() == 40)
				return ints;
		}

		return -1;
	}

	public void permute(int[] nums, int start, int end, List<Integer> list) {
		if (start == end) {
			list.add(wholeNumber(nums));
		} else {
			for (int i = start; i <= end; i++) {
				swap(nums, start, i);
				permute(nums, start + 1, end, list);
				swap(nums, start, i);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		if (i == j)
			return;
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}

	private int wholeNumber(int[] nums) {
		int sum = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			sum += nums[i] * Math.pow(10, len - i - 1);
		}
		return sum;
	}

	public static void main(String[] args) {
		int serverNumber = 1231;
		// int clientNumber = 1234;

		Predictor app = new Predictor(serverNumber);
		int answer = app.predict();
		System.out.println("Number is " + answer);
	}

}
