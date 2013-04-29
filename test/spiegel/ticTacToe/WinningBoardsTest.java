package spiegel.ticTacToe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WinningBoardsTest {

	@Test
	public void testWinningBoards() throws Exception {
		WinningBoards winBoards = new WinningBoards();
		TTTBoard board = new TTTBoard();
		board.fillToTest((char) 0, (char) 0, 'o', (char) 0, 'x', 'o', 'x',
				(char) 0, (char) 0);
		System.out.println(board);
		assertEquals(2, winBoards.nextMove(board).get(0).x);
		assertEquals(2, winBoards.nextMove(board).get(0).y);
		// System.out.println(winBoards.getUniqueBoards());
		// System.out.println(winBoards.getFinishingBoards());

	}

}
