package spiegel.maxSum;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class MaxSumTest {

	@Test
	public void testMaxSum3() {
		int array[][] = { { 9, 2, 3 }, { 1, 3, 7 }, { 1, 1, -10 } };
		MaxSum maxSum = new MaxSum(array);
		assertEquals(25, maxSum.getMaxSum());

	}

	@Test
	public void testMaxSum4() {
		int array[][] = { { 1, 3, 4, 5 }, { -10, 25, 17, 3 },
				{ -20, 17, 3, 1 }, { 5, -10, 6, 3 } };
		MaxSum maxSum = new MaxSum(array);
		assertEquals(78, maxSum.getMaxSum());
		System.out.println(maxSum.toString());
	}

	@Test
	public void testMaxSum50() {
		Random random = new Random();
		int array[][] = new int[50][50];
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				array[i][j] = random.nextInt(255) - 127;
			}
		}
		MaxSum maxSum = new MaxSum(array);
		System.out.println(maxSum.getMaxSum());
	}
}
