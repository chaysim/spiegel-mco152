package spiegel.dictionary;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GameLists {

	private final ArrayList<String> wordsOnBoard;
	private final ArrayList<Character> pool;
	private final ArrayList<Character> usedLetters;
	private final WordList wordList;

	public GameLists(ArrayList<String> wordsOnBoard, ArrayList<Character> pool,
			ArrayList<Character> usedLetters) throws FileNotFoundException {
		this.wordsOnBoard = wordsOnBoard;
		this.pool = pool;
		this.usedLetters = usedLetters;
		this.wordList = new WordList();
	}

	public GameLists() throws FileNotFoundException {
		wordsOnBoard = new ArrayList<String>();
		pool = new ArrayList<Character>();
		usedLetters = new ArrayList<Character>();
		this.wordList = new WordList();
	}

	public void addWordToBoard(String word) {
		wordsOnBoard.add(word);
		for (int c = 0; c < word.length(); c++) {
			pool.remove(word.charAt(c));
		}
	}

	public void findConnectingWords(char letter) {
		pool.add(letter);
		ArrayList<String> connectingWords = wordList.wordsFromTiles(pool);
		String word;
		for (int i = 0; i < connectingWords.size(); i++) {
			word = connectingWords.get(i);
			if (!containsLetter(word, letter)) {
				connectingWords.remove(word);
			}
		}

	}

	private boolean containsLetter(String word, char letter) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == letter) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Character> getUsedLetters() {
		return usedLetters;
	}

}
