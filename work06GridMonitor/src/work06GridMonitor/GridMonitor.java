package work06GridMonitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GridMonitor implements GridMonitorInterface{
	private Scanner file;
	private String filename;
	private double[][] origArray;
	private double[][] sumArray;
	private double[][] avgArray;
	private double[][] deltaArray;

	
	public GridMonitor(String filename) throws FileNotFoundException {
		this.filename = filename;
		this.file = new Scanner(new File("/home/student/Eclipse/work06GridMonitor/src/" + filename));
	}
	
	public double[][] getBaseGrid() {

		int row = file.nextInt();
		int col = file.nextInt();
		double[][] array = new double[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (file.hasNextInt()) {
					array[i][j] = file.nextInt();
				}
				else if (file.hasNextDouble()) {
					array[i][j] = file.nextDouble();
				}
			}
		}

		try {
			file.close();
			this.file = new Scanner(new File("/home/student/Eclipse/work06GridMonitor/src/" + filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		this.origArray = array;
		return origArray;
	}

	public double[][] getSurroundingSumGrid() {
		getBaseGrid();
		double[][] array = origArray;
		int row = array.length;
		int col = array[0].length;
		double[][] sumArray = new double[row][col];
		if (row == 1 && col == 1) {
			sumArray[0][0] = 4 * array[0][0];
		}
		else if (row == 1) {
			for (int j = 0; j < col; j++) {
				if (j != 0 || j + 1 != col) {
					sumArray[0][j] = 2 * array[0][j] + array[0][j-1] + array[0][j+1];
				}
				else if(j == 0) {
					sumArray[0][j] = 3 * array[0][j] + array[0][j+1];
				}
				else if (j + 1 == col) {
					sumArray[0][j] = 3 * array[0][j] + array[0][j-1];
				}
			}
		}
		else if (col == 1) {
			for (int i = 0; i < row; i++) {
				if (i != 0 || i + 1 != row) {
					sumArray[i][0] = 2 * array[i][0] + array[i+1][0] + array[i-1][0];
				}
				else if(i == 0) {
					sumArray[i][0] = 3 * array[i][0] + array[i+1][0];
				}
				else if (i + 1 == row) {
					sumArray[i][0] = 3 * array[i][0] + array[i-1][0];
				}
			}
		}
		else {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					// Upper-left corner
					if (i == 0 && j == 0) {
						sumArray[i][j] = array[i][j] + array[i][j] + array[i+1][j] + array[i][j+1];
					}
					// Upper border, excluding corners
					else if (i == 0 && j + 1 < col) {
						sumArray[i][j] = array[i][j] + array[i][j-1] + array[i][j+1] + array[i + 1][j];
					}
					// Upper-right corner
					else if (i == 0 && j + 1 == col) {
						sumArray[i][j] = array[i][j] + array[i][j] + array[i][j-1] + array[i+1][j];
					}
					// Left border, excluding corners
					else if (i + 1 < row && j == 0) {
						sumArray[i][j] = array[i][j] + array[i-1][j] + array[i+1][j] + array[i][j+1];
					}
					// Lower-left corner
					else if (i + 1 == row && j == 0) {
						sumArray[i][j] = array[i][j] + array[i][j] + array[i-1][j] + array[i][j+1];
					}
					// Lower border, excluding corners
					else if (i + 1 == row && j + 1 < col) {
						sumArray[i][j] = array[i][j] + array[i][j-1] + array[i][j+1] + array[i-1][j];
					}
					// Lower-right corner
					else if (i + 1 == row && j + 1 == col) {
						sumArray[i][j] = array[i][j] + array[i][j] + array[i][j-1] + array[i-1][j];
					}
					// Right border, excluding corners
					else if (i + 1 < row && j + 1 == col) {
						sumArray[i][j] = array[i-1][j] + array[i+1][j] + array[i][j-1] + array[i][j];
					}
					else {
						sumArray[i][j] = array[i-1][j] + array[i+1][j] + array[i][j-1] + array[i][j+1];
					}
				}
			}
		}
		this.sumArray = sumArray;
		return this.sumArray;
	}

	public double[][] getSurroundingAvgGrid() {
		getSurroundingSumGrid();
		double[][] sumArray = this.sumArray;
		int row = sumArray.length;
		int col = sumArray[0].length;
		double[][] avgArray = new double[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				avgArray[i][j] = sumArray[i][j] / 4;
			}
		}
		this.avgArray = avgArray;
		return avgArray;
	}

	public double[][] getDeltaGrid() {
		getSurroundingAvgGrid();
		double[][] avgArray = this.avgArray;
		int row = avgArray.length; 
		int col = avgArray[row - 1].length;
		double[][] deltaArray = new double[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				deltaArray[i][j] = Math.abs(avgArray[i][j] / 2);
			}
		}
		this.deltaArray = deltaArray;
		return deltaArray;
	}

	public boolean[][] getDangerGrid() {
		getDeltaGrid();
		double[][] avgArray = this.avgArray;
		double[][] deltaArray = this.deltaArray;
		double[][] array = origArray;
		int row = avgArray.length;
		int col = avgArray[0].length;
		boolean[][] dangerGrid = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if ((array[i][j] < avgArray[i][j] - deltaArray[i][j]) || (array[i][j] > avgArray[i][j] + deltaArray[i][j])) {
					dangerGrid[i][j] = true;
				}
				else {
					dangerGrid[i][j] = false;
				}
			}
		}
		return dangerGrid;
	}

}
