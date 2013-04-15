package spiegel.ticTacToe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TTTBoardTest {
	private TTTBoard boardH = new TTTBoard();
	private TTTBoard boardV = new TTTBoard();
	private TTTBoard boardD = new TTTBoard();
	private TTTBoard boardN = new TTTBoard();

	public void fillBoard() {
		boardH.fillToTest('x', 'x', 'x', 'd', 'e', 'f', 'g', 'h', 'i');
		boardV.fillToTest('x', 'y', 'x', 'x', 'e', 'f', 'x', 'h', 'i');
		boardD.fillToTest('x', 'y', 'x', 'd', 'x', 'f', 'g', 'h', 'x');
		boardN.fillToTest('x', 'y', 'x', 'd', 'e', 'f', 'g', 'h', 'i');
		System.out.print(boardH.toString());
	}

	@Test
	public void testLose() {
		fillBoard();
		assertFalse(boardN.checkWin());
		assertFalse(boardN.winHorizontal());
		assertFalse(boardN.winVertical());
		assertFalse(boardN.winDiagonal());
	}

	@Test
	public void testWinDiagonal() {
		fillBoard();
		assertTrue(boardD.winDiagonal());
		assertFalse(boardD.winVertical());
		assertFalse(boardD.winHorizontal());
	}

	@Test
	public void testWinHorizontal() {
		fillBoard();
		assertTrue(boardH.winHorizontal());
		assertFalse(boardH.winVertical());
		assertFalse(boardH.winDiagonal());
	}

	@Test
	public void testWinVertical() {
		fillBoard();
		assertTrue(boardV.winVertical());
		assertFalse(boardV.winHorizontal());
		assertFalse(boardV.winDiagonal());
	}

}
