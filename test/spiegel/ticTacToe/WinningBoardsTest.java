package spiegel.ticTacToe;

import org.junit.Test;

public class WinningBoardsTest {

	@Test
	public void testWinningBoards() {
		WinningBoards winBoards = new WinningBoards();
		System.out.println(winBoards.getUniqueBoards());
		System.out.println(winBoards.getFinishingBoards());
		System.out.println(winBoards.toString());
	}

}
