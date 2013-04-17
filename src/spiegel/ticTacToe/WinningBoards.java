package spiegel.ticTacToe;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
//need number of unique wins and ties
//need number of unique boards
//given a board, who will win

public class WinningBoards {
	private Stack<TTTBoard> boards;
	private ArrayList<TTTBoard> winningBoards;
	private HashMap<TTTBoard, TTTBoard> uniqueBoards;

	public WinningBoards() {
		this.boards = new Stack<TTTBoard>();
		this.winningBoards = new ArrayList<TTTBoard>();
		this.uniqueBoards = new HashMap<TTTBoard, TTTBoard>();
		fillBoardsOrginal();
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
			uniqueBoards.put(aBoard, aBoard);
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
			uniqueBoards.put(aBoard, aBoard);
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

	public int getNumBoards() {
		return winningBoards.size() + boards.size();
	}

	public int getUniqueBoards() {
		return uniqueBoards.size();
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
