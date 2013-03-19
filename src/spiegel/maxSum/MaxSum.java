package spiegel.maxSum;

import java.util.ArrayList;

public class MaxSum {

	private int[][] array;
	private ArrayList<Integer> numbersInMax;
	public int maxSum;

	public MaxSum(int[][] array) {
		this.array = array;
		this.numbersInMax = new ArrayList<Integer>();
		this.maxSum = array[0][0];
		numbersInMax.add(maxSum);
		findMax();
	}

	public int[][] getArray() {
		return array;
	}

	public void setArray(int[][] array) {
		this.array = array;
	}

	public int getMaxSum() {
		return maxSum;
	}

	public void findMax() {
		int size = array.length;
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				getMaxSumSquare(row, col);
			}
		}
	}

	public void getMaxSumSquare(int row, int col) {
		for (int i = array.length; i > 0; i--) {
			getMaxSumWidth(row, col, i, array.length);
			getMaxSumLength(row, col, array.length - 1, i);
		}
	}

	public void getMaxSumWidth(int r, int c, int rowSize, int colSize) {
		int max = 0;
		ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
		for (int row = r; row < rowSize; row++) {
			for (int col = c; col < colSize; col++) {
				tempArrayList.add(array[row][col]);
				max += array[row][col];
			}
		}
		if (max > maxSum) {
			maxSum = max;
			numbersInMax = tempArrayList;
		}
		if (colSize > 0) {
			getMaxSumWidth(r, c, rowSize, --colSize);
		}
	}

	public void getMaxSumLength(int r, int c, int rowSize, int colSize) {
		int max = 0;
		ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
		for (int row = r; row < rowSize; row++) {
			for (int col = c; col < colSize; col++) {
				tempArrayList.add(array[row][col]);
				max += array[row][col];
			}
		}
		if (max > maxSum) {
			maxSum = max;
			numbersInMax = tempArrayList;
		}
		if (rowSize > 0) {
			getMaxSumWidth(r, c, --rowSize, colSize);
		}
	}

	@Override
	public String toString() {
		String info = "MaxSum is " + maxSum + "\n";
		info += "Original numbers are " + "\n";
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				info += array[i][j] + " ";
			}
			info += "\n";
		}
		info += "Numbers in Max = ";
		for (int i = 0; i < numbersInMax.size(); i++) {
			info += numbersInMax.get(i) + " ";
		}
		return info;
	}
}