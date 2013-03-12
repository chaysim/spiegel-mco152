package spiegel.interviews;

public class FastestLetterSort {

	private char[] array;

	public FastestLetterSort(String book) {

		this.array = book.toCharArray();

	}

	public void sortLetters() {
		int[] numberOfOccurrences = new int[256];
		for (char letter : array) {
			numberOfOccurrences[letter]++;
		}
		// caps
		for (char i = 65; i < 91; i++) {
			System.out.println(i + " " + numberOfOccurrences[i]);
		}
		// lower case
		for (char i = 97; i < 123; i++) {
			System.out.println(i + " " + numberOfOccurrences[i]);
		}
	}

	public static void main(String[] args) {
		FastestLetterSort fs = new FastestLetterSort("words and more");
		fs.sortLetters();
	}

}
