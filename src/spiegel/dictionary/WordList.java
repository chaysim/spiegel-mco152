package spiegel.dictionary;

import java.io.File;
//based on distribution, take 7 tiles, find all words in it
//write a unit test with 7 tiles that you choose
import java.io.FileNotFoundException;

import java.util.*;
import java.util.Map.Entry;

public class WordList {

	private Map<String, ArrayList<Character>> words;
	public Map<String, ArrayList<Character>> getWords() {
		return words;
	}

	private TileBag tiles;
	private ArrayList<Character> letters;

	public WordList() throws FileNotFoundException {
		File file = new File("./wordlist.txt");
		Scanner readFromFile = new Scanner(file);
		words = new HashMap<String, ArrayList<Character>>();
		while (readFromFile.hasNextLine()) {
			String word = readFromFile.nextLine();
			// put each word in its list in both maps
			ArrayList<Character> wordOrdered = wordToChar(word);
			words.put(word, wordOrdered);
		}
		readFromFile.close();
		tiles = new TileBag();
		letters = new ArrayList<Character>();

	}

	public ArrayList<Character> wordToChar(String word) {
		ArrayList<Character> one = new ArrayList<Character>();
		for (int i = 0; i < word.length(); i++) {
			one.add(word.charAt(i));
		}
		Collections.sort(one);
		return one;
	}

	public ArrayList<Character> pickTiles(int num){
		letters = tiles.getSomeLetters(num);
		return letters;
	}
	public ArrayList<String> wordsFromTiles(ArrayList<Character> letters2) {
		//the arraylist with the words
		ArrayList<String> tileWords = new ArrayList<String>();
		//the arraylist with the letters
		letters = letters2;
		//go through the hashmap of words
		for (Entry<String, ArrayList<Character>> entry : words.entrySet()) {
			ArrayList<Character> value = entry.getValue();
			//if the letters have every letter in the current word
			if (letters.containsAll(value)) {
				//get a copy of the letters arraylist
				ArrayList<Character> copyLetters = new ArrayList<Character>();
				for (Character l : letters) {
					copyLetters.add(l);
				}
				boolean matches = true;
				//for every letter in the word, remove the letter from the copy
				for (Character l : value) {
					if (copyLetters.contains(l)) {
						copyLetters.remove(l);
					} else {
						//the letter is no longer in the copy, so the word isn't an anagram
						matches = false;
						break;
					}
				}
				//if the word is an anagram, add it
				if (matches == true) {
					tileWords.add(entry.getKey());
				}
			}

		}
		return tileWords;
	}
	public ArrayList<String> wordsFromTiles(int num) {
		//the arraylist with the words
		ArrayList<String> tileWords = new ArrayList<String>();
		//the arraylist with the letters
		letters = pickTiles(num);
		//go through the hashmap of words
		for (Entry<String, ArrayList<Character>> entry : words.entrySet()) {
			ArrayList<Character> value = entry.getValue();
			//if the letters have every letter in the current word
			if (letters.containsAll(value)) {
				//get a copy of the letters arraylist
				ArrayList<Character> copyLetters = new ArrayList<Character>();
				for (Character l : letters) {
					copyLetters.add(l);
				}
				boolean matches = true;
				//for every letter in the word, remove the letter from the copy
				for (Character l : value) {
					if (copyLetters.contains(l)) {
						copyLetters.remove(l);
					} else {
						//the letter is no longer in the copy, so the word isn't an anagram
						matches = false;
						break;
					}
				}
				//if the word is an anagram, add it
				if (matches == true) {
					tileWords.add(entry.getKey());
				}
			}

		}
		return tileWords;
	}

	public boolean contains(String word) {
		return words.containsKey(word);
	}

	public boolean anagramHashMap(String word, String word2) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		// puts first word in map
		for (int i = 0; i < word.length(); i++) {
			if (map.containsKey(word.charAt(i))) {
				Integer inum = map.get(word.charAt(i));
				map.put(word.charAt(i), ++inum);
			} else {
				map.put(word.charAt(i), 1);
			}

		}
		// checks second word
		for (int j = 0; j < word2.length(); j++) {
			if (!map.containsKey(word2.charAt(j))) {
				return false;
			} else {
				Integer jnum = map.get(word2.charAt(j));
				map.put(word2.charAt(j), --jnum);
			}

		}
		// checks if they are all 0
		for (int k = 0; k < word2.length(); k++) {
			Integer knum = map.get(word2.charAt(k));
			if (knum != 0)
				return false;
		}

		return true;
	}

	public boolean arrayAnagram(String word1, String word2) {
		// sort the words and then compare
		if (word1.length() != word2.length()) {
			return false;
		}
		char[] one = new char[word1.length()];
		char[] two = new char[word2.length()];
		for (int i = 0; i < word1.length(); i++) {
			one[i] = word1.charAt(i);
		}
		for (int j = 0; j < word1.length(); j++) {
			two[j] = word2.charAt(j);
		}
		Arrays.sort(one);
		Arrays.sort(two);
		for (int k = 0; k < word1.length(); k++) {
			if (one[k] != two[k])
				return false;
		}
		return true;
	}

	public ArrayList<Character> getLetters() {
		return letters;
	}

}
