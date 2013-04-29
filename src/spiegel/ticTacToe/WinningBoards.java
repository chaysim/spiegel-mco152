package spiegel.ticTacToe;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

//given a board, who will win - return a list

public class WinningBoards {
	private Stack<TTTBoard> boards;
	private HashMap<ArrayList<Character>, TTTBoard> uniqueBoards;
	private HashMap<ArrayList<Character>, TTTBoard> uniqueFinishedBoards;

	public WinningBoards() {
		this.boards = new Stack<TTTBoard>();
		this.uniqueBoards = new HashMap<ArrayList<Character>, TTTBoard>();
		this.uniqueFinishedBoards = new HashMap<ArrayList<Character>, TTTBoard>();
		// fillBoardsOrginal();
	}

	public ArrayList<Point> nextMove(TTTBoard board) throws Exception {
		ArrayList<Point> spots = board.getEmptySpots();
		ArrayList<Point> winningSpots = new ArrayList<Point>();
		if (spots.size() == 0) {
			throw new Exception("No spaces left");
		} else if (board.checkWin()) {
			throw new Exception("Already won");
		} else if (spots.size() == 9) {
			Point point = new Point(1, 1);
			winningSpots.add(point);
			return winningSpots;
		}

		char turn = getChar(spots.size());
		winningSpots = checkMove(spots, board, turn);
		return winningSpots;
	}

	public ArrayList<Point> checkMove(ArrayList<Point> spot, TTTBoard board,
			char turn) {
		ArrayList<Point> winningSpots = new ArrayList<Point>();
		Stack<TTTBoard> boards = new Stack<TTTBoard>();
		for (int i = 0; i < spot.size(); i++) {
			TTTBoard aBoard = new TTTBoard(board);
			aBoard.getBoard()[spot.get(i).x][spot.get(i).y] = turn;
			aBoard.setStart(spot.get(i));
			if (spot.size() < 6) {
				if (aBoard.checkWin()) {
					winningSpots.add(spot.get(i));
				} else {
					boards.add(aBoard);
				}
			} else {
				boards.add(aBoard);
			}
		}
		if (!winningSpots.isEmpty()) {
			return winningSpots;
		} else {
			winningSpots = checkMove2(boards, turn);
		}
		return winningSpots;
	}

	public ArrayList<Point> checkMove2(Stack<TTTBoard> boards, char player) {
		ArrayList<Point> winningSpots = new ArrayList<Point>();
		ArrayList<TTTBoard> tempArray = new ArrayList<TTTBoard>();
		while (!boards.isEmpty()) {
			TTTBoard aBoard = boards.pop();
			ArrayList<Point> spots = aBoard.getEmptySpots();
			char turn = getChar(spots.size());
			ArrayList<TTTBoard> tempArray2 = new ArrayList<TTTBoard>();
			for (int i = 0; i < spots.size(); i++) {
				TTTBoard board = new TTTBoard(aBoard);
				board.getBoard()[spots.get(i).x][spots.get(i).y] = turn;
				if (spots.size() < 6) {
					if (board.checkWin()) {
						if (turn == player) {
							winningSpots.add(board.getStart());
							break;
						} else {
							break;
						}

					} else {
						tempArray2.add(board);
					}
				} else {
					tempArray.add(board);
				}
			}
			if (tempArray2.size() == spots.size()) {
				// didn't break out because of loss or win
				tempArray.addAll(tempArray2);
			}
		}
		if (winningSpots.isEmpty()
				&& tempArray.get(0).getEmptySpots().size() != 0) {
			boards.addAll(tempArray);
			winningSpots = checkMove2(boards, player);
		}
		return winningSpots;
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

	private char getChar(int numSpots) {
		if (numSpots % 2 == 0) {
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
