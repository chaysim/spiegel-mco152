package spiegel.ticTacToe;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

//given a board, who will win

public class WinningBoards {
	private Stack<TTTBoard> boards;
	private HashMap<ArrayList<Character>, TTTBoard> uniqueBoards;
	private HashMap<ArrayList<Character>, TTTBoard> uniqueFinishedBoards;

	public WinningBoards() {
		this.boards = new Stack<TTTBoard>();
		this.uniqueBoards = new HashMap<ArrayList<Character>, TTTBoard>();
		this.uniqueFinishedBoards = new HashMap<ArrayList<Character>, TTTBoard>();
		fillBoardsOrginal();
	}

	public void fillBoards2(int numSpacesLeft) {
		ArrayList<TTTBoard> tempArray = new ArrayList<TTTBoard>();
		while (!boards.empty()) {
			tempArray.addAll(fillBoards3(numSpacesLeft, boards.pop()));
		}
		boards.addAll(tempArray);
		while (numSpacesLeft >= 1) {
			fillBoards2(--numSpacesLeft);
		}
		fillUniqueFinished();
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
			uniqueBoards.put(toCharArrayList(aBoard), aBoard);
			if (numBoards <= 5) {
				if (aBoard.checkWin()) {
					uniqueFinishedBoards.put(toCharArrayList(aBoard), aBoard);
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
			uniqueBoards.put(toCharArrayList(aBoard), aBoard);
			boards.add(aBoard);
		}
		fillBoards2(8);
	}

	private void fillUniqueFinished() {
		for (TTTBoard board : boards) {
			uniqueFinishedBoards.put(toCharArrayList(board), board);
		}
	}

	private char getChar(int numBoards) {
		if (numBoards % 2 == 0) {
			return 'o';
		} else {
			return 'x';
		}
	}

	public int getFinishingBoards() {
		return uniqueFinishedBoards.size();
	}

	public int getUniqueBoards() {
		return uniqueBoards.size();
	}

	public ArrayList<Character> toCharArrayList(TTTBoard board) {
		ArrayList<Character> letters = new ArrayList<Character>();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				letters.add(board.getBoard()[row][col]);
			}
		}
		return letters;
	}

	@Override
	public String toString() {
		String info = "Winning boards \n";
		for (TTTBoard board : uniqueFinishedBoards.values()) {
			info += board.toString() + "\n";
		}
		return info;
	}
}
