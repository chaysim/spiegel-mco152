package spiegel.dictionary;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;

public class WordList {

	private Map<Integer, LinkedList<String>> bySize;

	public WordList() throws FileNotFoundException {
		File file = new File("./wordlist.txt");
		Scanner readFromFile = new Scanner(file);

		bySize = new HashMap<Integer, LinkedList<String>>();

		// create hashmap of sizes
		for (int i = 0; i < 21; i++) {
			LinkedList<String> sizes = new LinkedList<String>();
			bySize.put(i + 1, sizes);
		}

		while (readFromFile.hasNextLine()) {
			String word = readFromFile.nextLine();
			// put each word in its list in both maps

			bySize.get(word.length()).add(word);
		}
		readFromFile.close();
	}

	public ArrayList<String> biggestAnagram() {
		ArrayList<String> biggest = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		// go through bySize
		for (Map.Entry<Integer, LinkedList<String>> entry : bySize.entrySet()) {
			Iterator<String> iterator = entry.getValue().iterator();

			HashMap<String, String> anagrammed = new HashMap<String, String>();
			while (iterator.hasNext()) {
				String word1 = iterator.next();
				anagrammed.put(word1, word1);
				temp.add(word1);
				Iterator<String> iterator2 = entry.getValue().iterator();
				while (iterator2.hasNext()) {

					String word2 = iterator2.next();
					if (!anagrammed.containsKey(word2)) {
						if (anagramHashMap(word1, word2)) {
							temp.add(word2);
						}
					}
				}
				if (temp.size() >= biggest.size()) {
					biggest = temp;
					temp = new ArrayList<String>();
				}
				temp = new ArrayList<String>();
			}
		}

		return biggest;
	}

	public boolean contains(String word) {
		return bySize.get(word.length()).contains(word);
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

}
