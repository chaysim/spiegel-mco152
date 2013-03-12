package spiegel.interviews;

import java.util.Random;

public class FastestSort {

	private int[] array;

	public FastestSort() {
		Random random = new Random();
		this.array = new int[100];
		for (int i = 0; i < 100; i++) {
			array[i] = random.nextInt(10001);
		}
	}

	public void sort() {
		int[] secondArray = new int[10001];
		for (int number : array) {
			secondArray[number]++;
		}
		for (int i = 0; i < 10001; i++) {
			System.out.println(i + " " + secondArray[i]);
		}
	}

	

	public static void main(String[] args) {
		FastestSort fs = new FastestSort();
		fs.sort();
	}

}
