package spiegel.dictionary;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Crossword {

	private final WordList wordlist;
	private final TileBag tilebag;
	private final ArrayList<String> wordsOnBoard;

	public Crossword() throws FileNotFoundException {
		this.wordlist = new WordList();
		this.tilebag = new TileBag();
		this.wordsOnBoard = new ArrayList<String>();
	}

	private boolean containsLetter(String word, char letter) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == letter) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<String> getConnectedWords(ArrayList<Character> pool) {
		ArrayList<String> wordsFromLetters = wordlist.wordsFromTiles(pool);
		String word;
		for (int j = 0; j < wordsFromLetters.size(); j++) {
			word = wordsFromLetters.get(j);
			wordsOnBoard.add(word);
			// pool = removeLettersFromPool(pool, word);
			// wordsFromLetters = recurFindConnecting(pool, word);
		}
		return null;
	}

	public TileBag getTilebag() {
		return tilebag;
	}

	public ArrayList<String> getWordsWithConnLetter(ArrayList<Character> pool,
			char connLetter) {
		ArrayList<String> possibleWords = wordlist.wordsFromTiles(pool);
		for (int i = 0; i < possibleWords.size(); i++) {
			String word = possibleWords.get(i);
			if (!containsLetter(word, connLetter)) {
				possibleWords.remove(word);
			}
		}
		return possibleWords;
	}

	public boolean recurFindConnecting(ArrayList<Character> pool, String word) {
		// this method will find a connecting word to add on to the words i
		// already have on my board
		// then it will recursively call itself on the new word
		// it should only do this!!!
		boolean canConnect = false;
		ArrayList<String> wordsFromLetters;
		for (char connLetter : word.toCharArray()) {
			pool.add(connLetter);
			wordsFromLetters = getWordsWithConnLetter(pool, connLetter);

			if (wordsFromLetters.size() != 0) {
				// if there are possible words to connect to this letter
				// let's go through them!

				for (String nextWord : wordsFromLetters) {
					wordsOnBoard.add(nextWord);
					canConnect = recurFindConnecting(pool, nextWord);
				}
				return canConnect;

			}

		}
		return false;

	}
}
