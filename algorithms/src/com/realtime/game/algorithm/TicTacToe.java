package com.realtime.game.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    private static char[][] grid;
    private static int row;
    private static int col;
    private static int gridDataCount;
    private static int gridDataSize;

    private static final char DEFAULT_GRID_VALUE = '#';
    private static final char FIRST_PLAYER_GRID_VALUE = '*';
    private static final char SECOND_PLAYER_GRID_VALUE = '0';

    enum Player {
	Player1("Player1", FIRST_PLAYER_GRID_VALUE), Player2("Player2", SECOND_PLAYER_GRID_VALUE);

	Player(String name, char input) {
	    this.name = name;
	    this.input = input;
	}

	private String name;
	private char input;

	public char getInput() {
	    return this.input;
	}

	public String getName() {
	    return this.name;
	}
    }

    static {
	row = col = 3;
	gridDataSize = row * col;
	grid = new char[row][col];

	for (char[] subGrid : grid) {
	    Arrays.fill(subGrid, DEFAULT_GRID_VALUE);
	}

	// char value = 'a';
	// for (int i = 0; i < row; i++) {
	// for (int j = 0; j < col; j++) {
	// grid[i][j] = (char) value;
	// }
	// }

	// grid[0][2] = '*';
	// grid[1][2] = '*';
	// grid[2][2] = '*';

	// grid[0][0] = '*';
	// grid[0][1] = '*';
	// grid[0][2] = '*';

	// grid[0][0] = '*';
	// grid[1][1] = '*';
	// grid[2][2] = '*';

	// grid[0][2] = '*';
	// grid[1][1] = '*';
	// grid[2][0] = '*';

    }

    public void printGrid() {
	System.out.println("<<GRID>>");
	for (char[] subGrid : grid) {
	    System.out.println(Arrays.toString(subGrid));
	}
    }

    public boolean checkGameStatus(Player player) {
	for (int i = 0; i < row; i++) {
	    if (checkRow(i, player) || checkColumn(i, player)) {
		return true;
	    }
	}
	return checkDiagonal(player);
    }

    public boolean moveExists() {
	return !(gridDataCount == gridDataSize);
    }

    // scanning column one by one - top -> bottom
    public boolean checkColumn(int col, Player player) {
	char ch = player.getInput();
	int count = 0;
	for (int i = 0; i < row; i++) {
	    if (grid[i][col] == ch) {
		count++;
	    }
	}
	return count == row;
    }

    // scanning row one by one - left -> right
    public boolean checkRow(int row, Player player) {
	char ch = player.getInput();
	int count = 0;
	for (int i = 0; i < col; i++) {
	    if (grid[row][i] == ch) {
		count++;
	    }
	}
	return count == col;
    }

    // scanning both the diagonals
    public boolean checkDiagonal(Player player) {
	int ch = player.getInput();
	int count = 0;
	for (int i = 0; i < col; i++) {
	    if (grid[i][i] == ch) {
		count++;
	    }
	}

	if (!(count == col)) {
	    count = 0;
	    for (int r = 0, c = col - 1; r < row && c >= 0; r++, c--) {
		if (grid[r][c] == ch) {
		    count++;
		}
	    }
	}
	return count == col;
    }

    public int[] parseInputAndValidate(String input) throws Exception {
	if (input == null || input.trim().isEmpty()) {
	    throw new Exception("Invalid input");
	}

	int r, c;

	int[] result = new int[3];
	String[] data = input.split(" ");
	r = result[0] = Integer.parseInt(data[0]);
	c = result[1] = Integer.parseInt(data[1]);

	if (r >= row || c >= col) {
	    throw new Exception("Invalid co-ordinates");
	}

	if (grid[r][c] != DEFAULT_GRID_VALUE) {
	    throw new Exception("Grid already have data, try again...:)");
	}

	return result;
    }

    public int[] getUserInput(Scanner in, Player player) throws Exception {
	System.out.println(player + " turns (x, y) : ");
	String input = in.nextLine();
	int[] data = parseInputAndValidate(input);
	data[2] = player.getInput();
	return data;
    }

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	TicTacToe obj = new TicTacToe();

	boolean player1Turn = true;
	boolean player2Turn = false;

	while (true) {
	    try {
		// 1. lets get input from Player1
		if (player1Turn) {
		    obj.printGrid();
		    int[] userInputPlayer1 = obj.getUserInput(in, Player.Player1);
		    obj.updateGridByUserInput(userInputPlayer1);
		    player1Turn = false;
		    player2Turn = true;
		}

		// 2. lets check the Game status
		if (obj.checkGameStatus(Player.Player1)) {
		    System.out.println("Player1 WINS!!!");
		    break;
		}

		// 3. If the grid full, out of move and neither player win
		if (!obj.moveExists()) {
		    System.out.println("Game DRAW!!!");
		    break;
		}

		// 4. lets get input from Player2
		if (player2Turn) {
		    obj.printGrid();
		    int[] userInputPlayer2 = obj.getUserInput(in, Player.Player2);
		    obj.updateGridByUserInput(userInputPlayer2);
		    player1Turn = true;
		    player2Turn = false;
		}

		// 5. lets check the Game status
		if (obj.checkGameStatus(Player.Player2)) {
		    System.out.println("Player2 WINS!!!");
		    break;
		}

		// 6. If the grid full, out of move and neither player win
		if (!obj.moveExists()) {
		    System.out.println("Game DRAW!!!");
		    break;
		}

	    } catch (Exception e) {
		System.out.println("Error : " + e.getMessage());
	    }
	}
    }

    private void updateGridByUserInput(int[] userInput) {
	grid[userInput[0]][userInput[1]] = (char) userInput[2];
	gridDataCount++;
    }
}
