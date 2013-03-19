package spiegel.maxSum;

import java.util.Scanner;

public class MaxSumMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		while (size < 1 || size > 100) {
			System.out.println("Size is not within range.");
			System.out.println("Size should be > 0 and < 100.");
			size = input.nextInt();
		}
		int[][] array = new int[size][size];

		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {

				array[row][col] = input.nextInt();
				while (array[row][col] > 127 || array[row][col] < -127) {
					System.out.println(array[row][col]
							+ " is not within range.");
					System.out.println("Enter a number between -127 and 127");
					array[row][col] = input.nextInt();
				}
			}
		}
		input.close();
		MaxSum maxSum = new MaxSum(array);
		System.out.println(maxSum.getMaxSum());
		System.out.println(maxSum.toString());
	}

}
