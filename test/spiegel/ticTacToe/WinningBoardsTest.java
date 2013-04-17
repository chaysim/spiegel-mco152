package spiegel.ticTacToe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WinningBoardsTest {

	@Test
	public void testWinningBoards() {
		WinningBoards winBoards = new WinningBoards();
		assertEquals(winBoards.getWinningBoards().size(), 209088);
		System.out.println(winBoards.getUniqueBoards());
	}

}
