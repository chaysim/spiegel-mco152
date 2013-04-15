package spiegel.ticTacToe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WinningBoardsTest {

	@Test
	public void testWinningBoards() {
		WinningBoards winBoards = new WinningBoards();
		winBoards.fillBoardsOrginal();
		assertEquals(winBoards.getWinningBoards().size(), 209088);
	}

}
