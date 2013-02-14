package spiegel.interviews;

import java.util.HashMap;

public class PrintWithoutDuplicates {

	private String[] unduplicated;

	public PrintWithoutDuplicates(String[] unduplicated) {

		this.unduplicated = unduplicated;
	}

	public void getArray() {

		// if it was a student you would do integer, student
		HashMap<String, String> hashMap = new HashMap<String, String>();
		for (int i = 0; i < unduplicated.length; i++) {
			if (!hashMap.containsKey(unduplicated[i]))
				hashMap.put(unduplicated[i], unduplicated[i]);
		
		}
		System.out.println(	hashMap.toString());

	}

	public static void main(String[] args) {
		String[] letters = { "d", "b", "b", "a" };
		PrintWithoutDuplicates a = new PrintWithoutDuplicates(letters);
		a.getArray();
	}
}
