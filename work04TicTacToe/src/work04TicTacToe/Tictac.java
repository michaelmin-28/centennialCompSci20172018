package work04TicTacToe;
import java.util.Scanner;

public class Tictac {

	public static void main(String[] args) {
		Toe lmao = new Toe();
		lmao.Boardprinter();
		lmao.Boardplayer();
	}

}

class Toe {
	// Initialize variables
	// 'gameboard' is the two-dimensional char array
	// 'print' is the visual of the board
	private char[][] gameboard = new char[3][3];
	private String print;
	
	// Constructor
	public Toe() {
	}
	
	// Creates the visual of the board
	public String Boardprinter() {
		String boardPrint = "     0     1     2\nA |_____|     |     |"
				+ "\nB |     |     |     |\nC |     |     |     |";
		// Changes the class value
		this.print = boardPrint;
		System.out.println(boardPrint);
		return boardPrint;
	}
	
	// The game
	public int Boardplayer() {
		// Initialize variables
		// 'turnChecker' switches turns between player one and two
		int turnChecker = 1;
		// 'win' checks for a tie
		boolean win = false;
		// 'whoWon' checks to see which player won at the end
		int whoWon = 0;
		// 'myBoard' lets us use the gameboard we initialized in the class
		char[][] myBoard = gameboard;
		// 'printBoard' lets us use the visual we created earlier
		// 'charBoard' is so we can change individual values within the board
		String printBoard = this.print; 
		char[] charBoard = printBoard.toCharArray();
		// 'rowCheck' lets us know if we make a three in a row
		boolean rowCheck = false;
		// Player 1
		// While the board is unfilled AND no one has made a three in a row
		while (turnChecker < 10 && rowCheck == false) {
			// If it's odd it starts with player one
			if ((turnChecker % 2) == 1) {
				// 'playerCheck' is to see if the player made a valid input
				boolean playerCheck = false;
				// while input is invalid or has not been made
				while(playerCheck == false) {
					Scanner in = new Scanner(System.in);
					System.out.println("Player One Enter Row: ");
					// Discover the row
					String row = in.nextLine();
					// The row must be one character
					while (row.length() < 0 || row.length() > 1) {
						System.out.println("You can't do that.");
						System.out.println("Player One Enter Row: ");
						row = in.nextLine();
					}
					// Does not allow for rows that are not 'a', 'b', or 'c'
					char rowChar = row.charAt(0);
					while (rowChar != 'A' && rowChar != 'a' && rowChar != 'B' && 
							rowChar != 'b' && rowChar != 'C' && rowChar != 'c') {
						System.out.println("You can't do that.");
						System.out.println("Player One Enter Row: ");
						row = in.nextLine();
						rowChar = row.charAt(0);
					}
					// Discovers the column 
					System.out.println("Player One Enter Col: ");
					String col = in.nextLine();
					// Does column must be one character
					while (col.length() < 0 || col.length() > 1) {
						System.out.println("You can't do that.");
						System.out.println("Player One Enter Col: ");
						col = in.nextLine();
					}
					char colChar = col.charAt(0);
					// The column must be '0', '1', or '2'
					while (colChar != '0' && colChar != '1' && colChar != '2') {
						System.out.println("You can't do that.");
						System.out.println("Player One Enter Col: ");
						col = in.nextLine();
						colChar = col.charAt(0);
					}
					// Changes the visual on the board, as well as the 
					// gameboard itself depending on the player input.
					// Also confirms if the player did not declare a value that 
					// has already been declared.
					if (rowChar == 'A' || rowChar == 'a') {
						if (colChar == '0' && myBoard[0][0] != 'X' && myBoard[0][0] != 'O') {
							myBoard[0][0] = 'X';
							charBoard[24] = 'X';
							playerCheck = true;
						}
						if (colChar == '1' && myBoard[0][1] != 'X' && myBoard[0][1] != 'O') {
							myBoard[0][1] = 'X';
							charBoard[30] = 'X';
							playerCheck = true;
						}
						if (colChar == '2' && myBoard[0][2] != 'X' && myBoard[0][2] != 'O') {
							myBoard[0][2] = 'X';
							charBoard[36] = 'X';
							playerCheck = true;
						}
					}
					else if (rowChar == 'B' || rowChar == 'b') {
						if (colChar == '0' && myBoard[1][0] != 'X' && myBoard[1][0] != 'O') {
							myBoard[1][0] = 'X';
							charBoard[46] = 'X';
							playerCheck = true;
						}
						if (colChar == '1' && myBoard[1][1] != 'X' && myBoard[1][1] != 'O') {
							myBoard[1][1] = 'X';
							charBoard[52] = 'X';
							playerCheck = true;
						}
						if (colChar == '2' && myBoard[1][2] != 'X' && myBoard[1][2] != 'O') {
							myBoard[1][2] = 'X';
							charBoard[58] = 'X';
							playerCheck = true;
						}
					}
					else if (rowChar == 'C' || rowChar == 'c') {
						if (colChar == '0' && myBoard[2][0] != 'X' && myBoard[2][0] != 'O') {
							myBoard[2][0] = 'X';
							charBoard[68] = 'X';
							playerCheck = true;
						}
						if (colChar == '1' && myBoard[2][1] != 'X' && myBoard[2][1] != 'O') {
							myBoard[2][1] = 'X';
							charBoard[74] = 'X';
							playerCheck = true;
						}
						if (colChar == '2' && myBoard[2][2] != 'X' && myBoard[2][2] != 'O') {
							myBoard[2][2] = 'X';
							charBoard[80] = 'X';
							playerCheck = true;
						}
					}
					if (playerCheck == false) {
						System.out.println("No duplicates!!!");
					}
				}
				// Checks to see if a three in a row has been made.
				if(myBoard[0][0] == 'X' && myBoard[0][1] == 'X' && myBoard[0][2] == 'X') {
					whoWon = 0;
					win = true;
					rowCheck = true;
				}
				else if(myBoard[1][0] == 'X' && myBoard[1][1] == 'X' && myBoard[1][2] == 'X') {
					whoWon = 0;
					win = true;
					rowCheck = true;
				}
				else if(myBoard[2][0] == 'X' && myBoard[2][1] == 'X' && myBoard[2][2] == 'X') {
					whoWon = 0;
					win = true;
					rowCheck = true;
				}
				else if(myBoard[0][0] == 'X' && myBoard[1][0] == 'X' && myBoard[2][0] == 'X') {
					whoWon = 0;
					win = true;
					rowCheck = true;
				}
				else if(myBoard[0][1] == 'X' && myBoard[1][1] == 'X' && myBoard[2][1] == 'X') {
					whoWon = 0;
					win = true;
					rowCheck = true;
				}
				else if(myBoard[0][2] == 'X' && myBoard[1][2] == 'X' && myBoard[2][2] == 'X') {
					whoWon = 0;
					win = true;
					rowCheck = true;
				}
				else if(myBoard[0][0] == 'X' && myBoard[1][1] == 'X' && myBoard[2][2] == 'X') {
					whoWon = 0;
					win = true;
					rowCheck = true;
				}
				else if(myBoard[0][2] == 'X' && myBoard[1][1] == 'X' && myBoard[2][0] == 'X') {
					whoWon = 0;
					win = true;
					rowCheck = true;
				}
				// Changes turns
				turnChecker++;
				// Prints out the updated visual
				printBoard = String.valueOf(charBoard);
				System.out.println(printBoard);
			}
			// Player 2
			// Same code as player one; just uses 'O' instead of 'X'
			else {
				boolean playerCheck = false;
				while (playerCheck == false) {
					Scanner in = new Scanner(System.in);
					System.out.println("Player Two Enter Row: ");
					String row = in.nextLine();
					while (row.length() < 0 || row.length() > 1) {
						System.out.println("You can't do that.");
						System.out.println("Player Two Enter Row: ");
						row = in.nextLine();
					}
					char rowChar = row.charAt(0);
					while (rowChar != 'A' && rowChar != 'a' && rowChar != 'B' && 
							rowChar != 'b' && rowChar != 'C' && rowChar != 'c') {
						System.out.println("You can't do that.");
						System.out.println("Player Two Enter Row: ");
						row = in.nextLine();
						rowChar = row.charAt(0);
					}
					System.out.println("Player Two Enter Col: ");
					String col = in.nextLine();
					while (col.length() < 0 || col.length() > 1) {
						System.out.println("You can't do that.");
						System.out.println("Player Two Enter Col: ");
						col = in.nextLine();
					}
					char colChar = col.charAt(0);
					while (colChar != '0' && colChar != '1' && colChar != '2') {
						System.out.println("You can't do that.");
						System.out.println("Player Two Enter Col: ");
						col = in.nextLine();
						colChar = col.charAt(0);
					}
					if (rowChar == 'A' || rowChar == 'a') {
						if (colChar == '0' && myBoard[0][0] != 'X' && myBoard[0][0] != 'O') {
							myBoard[0][0] = 'O';
							charBoard[24] = 'O';
							playerCheck = true;
						}
						if (colChar == '1' && myBoard[0][1] != 'X' && myBoard[0][1] != 'O') {
							myBoard[0][1] = 'O';
							charBoard[30] = 'O';
							playerCheck = true;
						}
						if (colChar == '2' && myBoard[0][2] != 'X' && myBoard[0][2] != 'O') {
							myBoard[0][2] = 'O';
							charBoard[36] = 'O';
							playerCheck = true;
						}
					}
					else if (rowChar == 'B' || rowChar == 'b') {
						if (colChar == '0' && myBoard[1][0] != 'X' && myBoard[1][0] != 'O') {
							myBoard[1][0] = 'O';
							charBoard[46] = 'O';
							playerCheck = true;
						}
						if (colChar == '1' && myBoard[1][1] != 'X' && myBoard[1][1] != 'O') {
							myBoard[1][1] = 'O';
							charBoard[52] = 'O';
							playerCheck = true;
						}
						if (colChar == '2' && myBoard[1][2] != 'X' && myBoard[1][2] != 'O') {
							myBoard[1][2] = 'O';
							charBoard[58] = 'O';
							playerCheck = true;
						}
					}
					else if (rowChar == 'C' || rowChar == 'c') {
						if (colChar == '0' && myBoard[2][0] != 'X' && myBoard[2][0] != 'O') {
							myBoard[2][0] = 'O';
							charBoard[68] = 'O';
							playerCheck = true;
						}
						if (colChar == '1' && myBoard[2][1] != 'X' && myBoard[2][1] != 'O') {
							myBoard[2][1] = 'O';
							charBoard[74] = 'O';
							playerCheck = true;
						}
						if (colChar == '2' && myBoard[2][2] != 'X' && myBoard[2][2] != 'O') {
							myBoard[2][2] = 'O';
							charBoard[80] = 'O';
							playerCheck = true;
						}
					}
					if (playerCheck == false) {
						System.out.println("No duplicates!!!");
					}
				}
				if(myBoard[0][0] == 'O' && myBoard[0][1] == 'O' && myBoard[0][2] == 'O') {
					whoWon = 1;
					win = true;
					rowCheck = true;
				}
				else if(myBoard[1][0] == 'O' && myBoard[1][1] == 'O' && myBoard[1][2] == 'O') {
					whoWon = 1;
					win = true;
					rowCheck = true;
				}
				else if(myBoard[2][0] == 'O' && myBoard[2][1] == 'O' && myBoard[2][2] == 'O') {
					whoWon = 1;
					rowCheck = true;
				}
				else if(myBoard[0][0] == 'O' && myBoard[1][0] == 'O' && myBoard[2][0] == 'O') {
					whoWon = 1;
					win = true;
					rowCheck = true;
				}
				else if(myBoard[0][1] == 'O' && myBoard[1][1] == 'O' && myBoard[2][1] == 'O') {
					whoWon = 1;
					rowCheck = true;
				}
				else if(myBoard[0][2] == 'O' && myBoard[1][2] == 'O' && myBoard[2][2] == 'O') {
					whoWon = 1;
					win = true;
					rowCheck = true;
				}
				else if(myBoard[0][0] == 'O' && myBoard[1][1] == 'O' && myBoard[2][2] == 'O') {
					whoWon = 1;
					win = true;
					rowCheck = true;
				}
				else if(myBoard[0][2] == 'O' && myBoard[1][1] == 'O' && myBoard[2][0] == 'O') {
					whoWon = 1;
					win = true;
					rowCheck = true;
				}
				turnChecker++;
				printBoard = String.valueOf(charBoard);
				System.out.println(printBoard);
			}
		}
		// Prints out a congratulations message.
		if (whoWon == 0 && win == true) {
			System.out.println("Congratulations to Player One!");
		}
		else if (whoWon == 1) {
			System.out.println("Congratulations to Player Two!");
		}
		else if (win == false) {
			System.out.println("It was a tie.");
		}
		return turnChecker;
	}
}
