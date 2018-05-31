package work07ConnectFour;

import java.util.Scanner;

public class Board {
	private int[][] board;
	private Scanner input;
	
	public Board() {
		this.board = new int[6][7];
	}
	
	public int boardCheck() {
		// Player One will be valued at '1', player two will be '2'
		int winner = 0;
		boolean solve = false;
		int row = 6;
		int col = 7;
		for (int i = 0; i < row; i++) {
			if (solve == true) {
				break;
			}
			for (int j = 0; j < col; j++) {
				if (solve == true) {
					break;
				}
				// Checking vertical
				if (i + 3 < row) {
					boolean vertCheck = true;
					while(vertCheck == true && board[i][j] != 0 && solve == false) {
						for (int k = i; k < i + 4; k++) {
							if (board[i][j] != board[k][j]) {
								vertCheck = false;
								solve = false;
								k += 4;
							}
							else {
								solve = true;
							}
						}
					}
					if ((vertCheck == true) && (board[i][j] != 0)) {
						winner = board[i][j];
					}	
				}
				// Checking horizontal
				if (j + 3 < col) {
					boolean horCheck = true;
					while (horCheck == true && board[i][j] != 0 && solve == false) {
						for (int l = j; l < j + 4; l++) {
							if (board[i][j] != board[i][l]) {
								horCheck = false;
								solve = false;
								l += 4;
							}
							else {
								solve = true;
							}
						}
					}
					if ((horCheck == true) && (board[i][j] != 0)) {
						winner = board[i][j];
					}
				}
				
				// Checking down-right diagonal
				if (i + 3 < row && j + 3 < col) {
					boolean diagCheck = true;
					int k = i;
					int l = j;
					while (diagCheck == true && board[i][j] != 0 && solve == false) {
						while (k < i + 4 && l < j + 4) {
							if (board[i][j] != board[k][l]) {
								diagCheck = false;
								solve = false;
								k += 4;
								l += 4;
							}
							else {
								solve = true;
							}
							k++;
							l++;
						}
					}
					if ((diagCheck == true) && (board[i][j] != 0)) {
						winner = board[i][j];
					}
				}
				
				// Checking down-left diagonal
				if (i + 3 < row && j - 3 >= 0) {
					boolean diagCheck = true;
					int k = i;
					int l = j;
					while (diagCheck == true && board[i][j] != 0 && solve == false) {
						while (k < i + 4 && l > j - 4) {
							if (board[i][j] != board[k][l]) {
								diagCheck = false;
								solve = false;
								k += 4;
								l -= 4;
							}
							else {
								solve = true;
							}
							k++;
							l--;
						}
					}
					if ((diagCheck == true) && (board[i][j] != 0)) {
						winner = board[i][j];
					}
				}
			}
		}
		return winner;
	}
	// Put tokens in with values equal to the player value
	public void boardChange(int input, int player) {
		for (int i = 5; i >= 0; i--) {
			if (this.board[i][input - 1] == 0) {
				this.board[i][input - 1] = player;
				i -= 6;
			}
		}
	}
	// Check if the input number has empty spaces left to put tokens in
	public boolean validInput(int input) {
		boolean valid = false;
		for (int i = 5; i >= 0; i--) {
			if (this.board[i][input - 1] == 0) {
				valid = true;
			}
		}
		return valid;
	}
	
	public String boardBuilder() {
		String stringBuilder = "";
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (board[i][j] == 0) {
					stringBuilder = stringBuilder + "| ";
				}
				else {
					stringBuilder = stringBuilder + "|" + board[i][j];
				}
				if (j == 6) {
					stringBuilder += "|\n";
				}
			}
		}
		stringBuilder = stringBuilder + " 1 2 3 4 5 6 7";
		return stringBuilder;
	}
	
	public int getPlay() {
		int value = 0;
		System.out.println("Please drop in a token in a column. ");
		input = new Scanner(System.in);
		while (!input.hasNextInt()) {
			System.out.println("That's not a number. ");
			System.out.println("Please drop in a token in a column. ");
			input = new Scanner(System.in);
		}
		value = input.nextInt();
		while (value < 1 || value > 7) {
			System.out.println("That is an invalid input. ");
			System.out.println("Please drop in a token in a column. ");
			value = input.nextInt();
		}
		return value;
	}
	
	public void closeScanner() {
		this.input.close();
	}
}
