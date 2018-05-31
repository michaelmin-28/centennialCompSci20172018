package frqTesting01;

import java.util.ArrayList;
import java.util.List;

public class QuestionOne {

	public static void main(String[] args) {
		int [] kek = ArrayCreator.firstArray();
		ArrayCreator.arraySum(kek);
		int [][] keke = ArrayCreator.secondArray();
		ArrayCreator.rowSums(keke);
		ArrayCreator.isDiverse(keke);
		HiddenWord lmao = new HiddenWord("HAPPY");
		lmao.getHint("HAAPY");
		
		Multiple kappa = new Multiple();
		kappa.stringy("Yes");
	}

}

class ArrayCreator {
	public ArrayCreator() {
		
	}
	
	public static int[] firstArray() {
		int [] arr1 = new int [5];
		arr1[0] = 1;
		arr1[1] = 3;
		arr1[2] = 2;
		arr1[3] = 7;
		arr1[4] = 3;
		return arr1;
	}
	
	public static int[][] secondArray() {
		int [][] arr2 = new int [4][5];
		arr2[0][0] = 1;
		arr2[0][1] = 3;
		arr2[0][2] = 2;
		arr2[0][3] = 7;
		arr2[0][4] = 3;
		arr2[1][0] = 10;
		arr2[1][1] = 10;
		arr2[1][2] = 4;
		arr2[1][3] = 6;
		arr2[1][4] = 2;
		arr2[2][0] = 5;
		arr2[2][1] = 3;
		arr2[2][2] = 5;
		arr2[2][3] = 9;
		arr2[2][4] = 6;
		arr2[3][0] = 7;
		arr2[3][1] = 6;
		arr2[3][2] = 4;
		arr2[3][3] = 2;
		arr2[3][4] = 1;
		return arr2;
	}
	
	public static int arraySum(int[] arr) {
		int totalSum = 0;
		for (int i = 0; i < arr.length; i++) {
			totalSum = totalSum + arr[i];
		}
		System.out.println(totalSum);
		return totalSum;
	}
	public static int[] rowSums(int[][] arr2D) {
		int [] rows = new int[arr2D.length];
		arr2D = secondArray();
		for(int i = 0; i < arr2D.length; i++) {
			rows[i] = arraySum(arr2D[i]);
		}
		return rows;
	}
	public static boolean isDiverse(int[][] arr2D) {
		boolean same = true;
		int[] rowVals = rowSums(arr2D);
		for (int i = 0; i < rowVals.length; i++) {
			int first = rowVals[i];
			for (int k = i+1; k < rowVals.length; k++) {
				int second = rowVals[k];
				if (first == second) {
					same = false;
				}
			}
		}
		System.out.println(same);
		return same;
	}
}

class Multiple {
	public Multiple() {
		
	}
	
	public String stringy(String str) {
		String kappa = "";
		List <String> stri = new ArrayList<String>();
		stri.add("Alex");
		stri.add("Bob");
		stri.add("Carl");
		for (int k = 0; k < stri.size(); k++) {
			System.out.println(stri.set(k, "Alex"));
		}
		return kappa;
	}
}