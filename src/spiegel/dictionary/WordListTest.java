package spiegel.dictionary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WordListTest {

	private WordList wordList;

	@Before
	public void setUp() throws Exception {
		wordList = new WordList();
	}

	@Test
	public void testDoesntContain() {
		assertFalse(wordList.contains("ab"));
		assertFalse(wordList.contains("zz"));
	}

	@Test
	public void testBiggestAnagram() {
		assertTrue(wordList.biggestAnagram().contains("alerts"));
	}

	@Test
	public void testContains() {
		assertTrue(wordList.contains("kaleyards"));
		assertTrue(wordList.contains("zymogene"));
	}

	@Test
	public void testHashAnagrams() {
		assertTrue(wordList.anagramHashMap("spear", "pears"));
		assertFalse(wordList.anagramHashMap("apple", "aplee"));
	}

	@Test
	public void testArrayAnagrams() {
		assertTrue(wordList.arrayAnagram("spear", "pears"));
		assertFalse(wordList.arrayAnagram("apple", "aplee"));
	}

}
