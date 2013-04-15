package spiegel.ticTacToe;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Stack;

public class WinningBoards {
	private Stack<TTTBoard> boards;
	private ArrayList<TTTBoard> winningBoards;

	public WinningBoards() {
		this.boards = new Stack<TTTBoard>();
		this.winningBoards = new ArrayList<TTTBoard>();
	}

	public void fillBoards2(int numSpacesLeft) {
		ArrayList<TTTBoard> tempArray = new ArrayList<TTTBoard>();
		while (!boards.empty()) {
			tempArray.addAll(fillBoards3(numSpacesLeft, boards.pop()));
		}
		boards.addAll(tempArray);
		while (numSpacesLeft >= 1) {
			System.out.println("\n");
			fillBoards2(--numSpacesLeft);
		}
	}

	private ArrayList<TTTBoard> fillBoards3(int numBoards, TTTBoard board) {
		ArrayList<TTTBoard> tempArray = new ArrayList<TTTBoard>();
		ArrayList<Point> spots = board.getEmptySpots();
		if (spots.size() == 0) {
			numBoards = 0;
		}

		for (int i = 0; i < numBoards; i++) {
			TTTBoard aBoard = new TTTBoard(board);
			aBoard.getBoard()[spots.get(i).x][spots.get(i).y] = getChar(numBoards);
			if (numBoards <= 5) {
				if (aBoard.checkWin()) {
					winningBoards.add(aBoard);
				} else {
					tempArray.add(aBoard);
				}
			} else {
				tempArray.add(aBoard);
			}
		}
		return tempArray;
	}

	public void fillBoardsOrginal() {
		for (int i = 0; i < 9; i++) {
			TTTBoard aBoard = new TTTBoard();
			aBoard.getBoard()[i / 3][i % 3] = 'x';
			boards.add(aBoard);
		}
		fillBoards2(8);
	}

	private char getChar(int numBoards) {
		if (numBoards % 2 == 0) {
			return 'o';
		} else {
			return 'x';
		}
	}

	public ArrayList<TTTBoard> getWinningBoards() {
		return winningBoards;
	}

	@Override
	public String toString() {
		String info = "Winning boards \n";
		for (TTTBoard board : winningBoards) {
			info += board.toString() + "\n";
		}
		return info;
	}
}
