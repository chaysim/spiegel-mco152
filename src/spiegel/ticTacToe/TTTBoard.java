package spiegel.ticTacToe;

import java.awt.Point;
import java.util.ArrayList;

public class TTTBoard {

	private char[][] board;

	public TTTBoard() {
		this.board = new char[3][3];
	}

	public TTTBoard(TTTBoard oldBoard) {
		this.board = new char[3][3];
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				board[row][col] = oldBoard.getBoard()[row][col];
			}
		}
	}

	public boolean checkAnyWins(ArrayList<TTTBoard> boards) {// for testing
		for (TTTBoard board : boards) {
			if (board.checkWin()) {
				return true;
			}
		}
		return false;
	}

	public boolean checkWin() {
		if (winDiagonal() || winHorizontal() || winVertical()) {
			return true;
		}
		return false;
	}

	public boolean compareTo(TTTBoard board) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (this.getBoard()[row][col] != board.getBoard()[row][col]) {
					return false;
				}
			}
		}
		return true;
	}

	public void fillToTest(char a, char b, char c, char d, char e, char f,
			char g, char h, char i) {
		board[0][0] = a;
		board[0][1] = b;
		board[0][2] = c;
		board[1][0] = d;
		board[1][1] = e;
		board[1][2] = f;
		board[2][0] = g;
		board[2][1] = h;
		board[2][2] = i;

	}

	public char[][] getBoard() {
		return board;
	}

	public ArrayList<Point> getEmptySpots() {
		ArrayList<Point> spots = new ArrayList<Point>();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == 'x' || board[row][col] == 'o') {
					continue;
				} else {
					Point p = new Point(row, col);
					spots.add(p);
				}
			}
		}
		return spots;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	@Override
	public String toString() {
		String info = "";
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				info += board[row][col] + "|";
			}
		}
		return info;
	}

	public boolean winDiagonal() {
		char first = board[0][0];
		if ((first == 'o' || first == 'x') && board[1][1] == first
				&& board[2][2] == first) {
			return true;
		}
		first = board[0][2];
		if ((first == 'o' || first == 'x') && board[1][1] == first
				&& board[2][0] == first) {
			return true;
		}
		return false;
	}

	public boolean winHorizontal() {
		for (int row = 0; row < 3; row++) {
			char first = board[row][0];
			if ((first == 'o' || first == 'x') && board[row][1] == first
					&& board[row][2] == first) {
				return true;
			}
		}
		return false;
	}

	public boolean winVertical() {
		for (int col = 0; col < 3; col++) {
			char first = board[0][col];

			if ((first == 'o' || first == 'x') && board[1][col] == first
					&& board[2][col] == first) {
				return true;
			}
		}
		return false;
	}
}
