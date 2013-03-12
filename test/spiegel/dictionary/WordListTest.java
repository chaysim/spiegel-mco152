package spiegel.dictionary;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;
import spiegel.dictionary.WordList;

public class WordListTest {

	@Test
	public void testDoesntContain() throws FileNotFoundException {
		WordList wordList = new WordList();
		assertFalse(wordList.contains("ab"));
		assertFalse(wordList.contains("zz"));
	}

	@Test
	public void testContains() throws FileNotFoundException {
		WordList wordList = new WordList();
		assertTrue(wordList.contains("kaleyards"));
		assertTrue(wordList.contains("zymogene"));
	}

	@Test
	public void testWordsFromTiles() throws FileNotFoundException {
		WordList wordList = new WordList();
		ArrayList<String> words = wordList.wordsFromTiles(5);
		System.out.println(wordList.getLetters());
		System.out.println(words);
		System.out.println(words.size());
	}

	@Test
	public void testWordsFromTiles2() throws FileNotFoundException {
		WordList wordList = new WordList();
		ArrayList<Character> tiles = new ArrayList<Character>();
		tiles.add('s');
		tiles.add('a');
		tiles.add('t');
		ArrayList<String> wordsToTest = new ArrayList<String>();
		wordsToTest.add("sat");
		wordsToTest.add("at");
		wordsToTest.add("as");
		wordsToTest.add("tas");
		wordsToTest.add("ta");
		assertTrue(wordList.wordsFromTiles(tiles).containsAll(wordsToTest));
	}

	@Test
	public void testHashAnagrams() throws FileNotFoundException {
		WordList wordList = new WordList();
		assertTrue(wordList.anagramHashMap("spear", "pears"));
		assertFalse(wordList.anagramHashMap("apple", "aplee"));
	}

	@Test
	public void testArrayAnagrams() throws FileNotFoundException {
		WordList wordList = new WordList();
		assertTrue(wordList.arrayAnagram("spear", "pears"));
		assertFalse(wordList.arrayAnagram("apple", "aplee"));
	}

}
