package prj03_2048;

public class Change {
	private boolean[][] filledBoard;
	private int [][] valueBoard;
	private boolean[] full;
	private boolean[] empty;
	
	public Change(int n) {
		this.filledBoard = new boolean[n][n];
		this.valueBoard = new int [n][n];
		this.full = new boolean[n];
		this.empty = new boolean[n];
		for (int i = 0; i < n; i++) {
			full[i] = true;
			empty[i] = false;
		}
	}
	
	public boolean[] canYouMove() {
		// Tests to see if there are empty spaces left on the board.
		// Empty spaces will be marked with 'false' while spaces with items 
		// will be marked with 'true.'
		// There are 4 spaces in the boolean array directionalMovement; 
		// 0 is up
		// 1 is right
		// 2 is left
		// 3 is down
		boolean[] directions = new boolean [4];
		boolean movable = false;
		int rows = filledBoard.length;
		int cols = filledBoard[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (filledBoard[i][j] == false) {
					movable = true;
				}
			}
		}
		// Check to see if you can move in a direction.
		// Check horizontal:
		for (int i = 0; i < rows; i++) {
			if (filledBoard[i] != full && filledBoard[i] != empty) {
				directions[1] = true;
				directions[2] = true;
			}
		}
		// Check vertical:
		// One struggle is in translating the boolean array into another array to check
		boolean[] array = new boolean[cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				array[j] = filledBoard[i][j];
			}
			if (array != full && array != empty) {
				directions[0] = true;
				directions[3] = true;
			}
		}
		// Check for combinables; if they exist,
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// Check upper-left corner
				if (i == 0 && j == 0) {
					// Checking downwards
					if (valueBoard[i][j] == valueBoard[i+1][j]) {
						directions[3] = true;
					}
					// Checking to the right
					if (valueBoard[i][j] == valueBoard[i][j+1]) {
						directions[1] = true;
					}
				}
				// Check top border excluding corners
				else if (i == 0 && j + 1 < cols) {
					// Checking downwards
					if (valueBoard[i][j] == valueBoard[i+1][j]) {
						directions[3] = true;
					}
					// Checking to the left
					if (valueBoard[i][j] == valueBoard[i][j-1]) {
						directions[2] = true;
					}
					// Checking to the right
					if (valueBoard[i][j] == valueBoard[i][j+1]) {
						directions[1] = true;
					}
				}
				// Check upper-right corner
				else if (i == 0 && j + 1 == cols) {
					if ((valueBoard[i][j] == valueBoard[i+1][j]) || (valueBoard[i][j] == valueBoard[i][j-1])) {
						movable = true;
					}
				}
				// Check left border excluding corners
				else if (i + 1 < rows && j == 0) {
					if ((valueBoard[i][j] == valueBoard[i+1][j]) || (valueBoard[i][j] == valueBoard[i-1][j]) || (valueBoard[i][j] == valueBoard[i][j+1])) {
						movable = true;
					}
				}
			}
		}
		return directions;
	}
	
}
