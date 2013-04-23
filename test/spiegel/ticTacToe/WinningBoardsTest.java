package spiegel.ticTacToe;

import org.junit.Test;

public class WinningBoardsTest {

	@Test
	public void testWinningBoards() throws Exception {
		WinningBoards winBoards = new WinningBoards();
		TTTBoard board = new TTTBoard();
		board.fillToTest('x', 'x', 'a', 'o', 'o', 'a', 'b', 'd', 'f');
		System.out.println(board);
		System.out.println(winBoards.nextMove(board));
		System.out.println(winBoards.getUniqueBoards());
		System.out.println(winBoards.getFinishingBoards());

	}

}
