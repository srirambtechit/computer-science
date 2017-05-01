package com.msrm.mastermind;

import java.util.Arrays;

public final class Checker2 {

	private int[] s;

	public Checker2(int number) {
		s = toArray(number);

	}

	private int[] toArray(int number) {
		int length = String.valueOf(number).length();
		int[] array = new int[length];
		int position = length;
		while (number > 0) {
			array[--position] = number % 10;
			number = number / 10;
		}
		return array;
	}

	public Result check(int number) {
		int[] c = toArray(number);

//		if (c.length != s.length) {
//			throw new IllegalArgumentException();
//		}

		int[] sci = new int[c.length];
		Arrays.fill(sci, -1);

		for (int i = 0; i < sci.length; i++) {
			if (s[i] == c[i]) {
				sci[i] = i;
			} else if (sci[i] == -1) {
				for (int j = 0; j < sci.length; j++) {
					if (s[i] == c[j]) {
						sci[i] = j;
						break;
					}
				}
			}
		}

		Result result = new Result();
		for (int i = 0; i < sci.length; i++) {
			if (sci[i] == i) {
				result.setPositionAndValueCount(result.getPositionAndValueCount() + 1);
				result.setPoints(result.getPoints() + 10);
			} else if (sci[i] != -1) {
				result.setValueCount(result.getValueCount() + 1);
				result.setPoints(result.getPoints() + 5);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int serverNumber = 1823;
		int clientNumber = 1111; // 7398, 2638,
		// int clientNumber = 2638, 3319;
		Checker2 na = new Checker2(serverNumber);
		int i = 0;
		while (i < 10) {
			Result result = na.check(clientNumber);
			System.out.printf("server: %d; client: %d; valuePosition: %d; value: %d; points: %d%n%n", serverNumber,
					clientNumber, result.getPositionAndValueCount(), result.getValueCount(), result.getPoints());
			clientNumber = (int) (Math.random() * 10000);
			while (String.valueOf(clientNumber).length() != 4) {
				clientNumber = (int) (Math.random() * 10000);
			}
			i++;
		}
	}

}
