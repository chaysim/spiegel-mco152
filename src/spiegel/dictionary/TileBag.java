package spiegel.dictionary;

import java.util.ArrayList;
import java.util.Random;

public class TileBag {

	private ArrayList<Character> letters;

	public TileBag() {

		this.letters = new ArrayList<Character>();
		fillBag();
	}

	public void fillBag() {
		addLetter(18, 'e');
		addLetter(13, 'a');
		addLetter(12, 'i');
		addLetter(11, 'o');
		addLetter(9, 'r');
		addLetter(9, 't');
		addLetter(8, 'n');
		addLetter(6, 'd');
		addLetter(6, 's');
		addLetter(6, 'u');
		addLetter(5, 'l');
		addLetter(4, 'g');
		addLetter(3, 'b');
		addLetter(3, 'c');
		addLetter(3, 'f');
		addLetter(3, 'h');
		addLetter(3, 'm');
		addLetter(3, 'p');
		addLetter(3, 'v');
		addLetter(3, 'w');
		addLetter(3, 'y');
		addLetter(2, 'j');
		addLetter(2, 'k');
		addLetter(2, 'q');
		addLetter(2, 'x');
		addLetter(2, 'z');

	}

	public void addLetter(int i, Character letter) {
		for (int j = 0; j < i; j++) {
			letters.add(letter);
			j++;
		}
	}

	public ArrayList<Character> getSomeLetters(int num) {
		Random randomNum = new Random();
		ArrayList<Character> someLetters = new ArrayList<Character>();
		for (int i = 0; i < num; i++) {
			int nextNum = randomNum.nextInt(letters.size() - 1);
			Character nextChar = letters.remove(nextNum);
			someLetters.add(nextChar);
		}
		return someLetters;
	}

	public ArrayList<Character> getLetters() {
		return letters;
	}

	public void setLetters(ArrayList<Character> letters) {
		this.letters = letters;
	}

}
