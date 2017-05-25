package com.msrm.realtime.game.algorithm;

import java.util.Arrays;

/**
 * Given a 9�9 sudoku we have to evaluate it for its correctness. We have to
 * check both the sub matrix correctness and the whole sudoku correctness.
 * 
 * @author Sriram
 *
 */
public class SudokuCorrectnessChecker {

    public static void main(String[] args) {
	System.out.println(Sudoku.printSudoku());
	SudokuCorrectnessChecker sc = new SudokuCorrectnessChecker();
	if (sc.checkSudoku()) {
	    System.out.println("Passed");
	} else {
	    System.out.println("Failed");
	}
    }

    public boolean checkSudoku() {
	int row = 0;
	int col = 0;
	int itr = 0;

	while (checkMatrix(Sudoku.data, row, col)) {
	    itr++;
	    col = col + 3;
	    if (col > 6) {
		row = row + 3;
		col = 0;
	    }
	    if (row > 6)
		break;
	}
	return itr == 9;
    }

    private boolean checkMatrix(int[][] data, int rowOffset, int colOffset) {
	int sum = 0;
	int sumValue = 45;

	for (int i = rowOffset; i < rowOffset + 3; i++) {
	    for (int j = colOffset; j < colOffset + 3; j++) {
		sum += data[i][j];
	    }
	}
	return sum == sumValue;
    }

    static class Sudoku {
	static int[][] data = new int[9][9];
	static {
	    for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
		    int value = (int) (Math.random() * 10);
		    data[i][j] = value;
		}
	    }

	    // comment out appropriate boxes to check the test cases
	    fillCorrectData(0, 0);
	    fillCorrectData(0, 3);
	    fillCorrectData(0, 6);

	    fillCorrectData(3, 0);
	    fillCorrectData(3, 3);
	    fillCorrectData(3, 6);

	    fillCorrectData(6, 0);
	    fillCorrectData(6, 3);
	    fillCorrectData(6, 6);
	}

	private static void fillCorrectData(int rowOffset, int colOffset) {
	    int n = 1;
	    for (int i = rowOffset; i < rowOffset + 3; i++) {
		for (int j = colOffset; j < colOffset + 3; j++) {
		    data[i][j] = n++;
		}
	    }
	}

	public static String printSudoku() {
	    StringBuffer buf = new StringBuffer();
	    buf.append("[\n");
	    for (int i = 0; i < 9; i++) {
		buf.append(Arrays.toString(data[i]) + "\n");
	    }
	    buf.append("]\n");
	    return buf.toString();
	}
    }

}
