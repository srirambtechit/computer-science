package com.msrm.mastermind;

public final class Checker {

	private int[] ints;

	public Checker(int number) {
		int length = String.valueOf(number).length();
		ints = new int[length];
		int position = length;
		while (number > 0) {
			ints[--position] = number % 10;
			number = number / 10;
		}
	}

	public Result check(int number) {
		Result result = new Result();

		int position = ints.length;
		int[] table = new int[ints.length];
		boolean[] ons = new boolean[ints.length];
		while (number > 0) {
			table[--position] = number % 10;
			number = number / 10;
		}

		// Checking matched position and value
		for (int i = 0; i < ints.length; i++) {
			if (ints[i] == table[i]) {
				result.setPositionAndValueCount(result.getPositionAndValueCount() + 1);
				result.setPoints(result.getPoints() + 10);
				ons[i] = true;
			}
		}

		// Checking matched value
		for (int i = 0; i < ints.length; i++) {
			if (!ons[i]) {
				for (int j = 0; j < ints.length; j++) {
					if (!ons[j] && table[i] == ints[j]) {
						result.setValueCount(result.getValueCount() + 1);
						result.setPoints(result.getPoints() + 5);
						ons[j] = true;
						break;
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int serverNumber = 1821;
		int clientNumber = 8784;
		// int clientNumber = 1111;
		Checker na = new Checker(serverNumber);
		int i = 0;
		while (i < 10) {
			Result result = na.check(clientNumber);
			System.out.printf("server: %d; client: %d; valuePosition: %d; value: %d; points: %d%n", serverNumber,
					clientNumber, result.getPositionAndValueCount(), result.getValueCount(), result.getPoints());
			clientNumber = (int) (Math.random() * 10000);
			i++;
		}
	}

}
