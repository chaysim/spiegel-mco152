package spiegel.interviews;

public class FindDouble {

	private int[] array;

	public FindDouble(int[] array) {

		this.array = array;
	}

	public int getDouble() throws Exception {
		int min = array[0];
		int first = 0;
		int mid;
		int last = array.length - 1;
		while (first <= last) {
			mid = (first + last) / 2;
			if (array[mid] == min + mid - 1 && array[mid-1]==array[mid]) {
				return array[mid];
			} else if (array[mid] == min + mid) {
				first = mid + 1;
			} else {
				last = mid - 1;
			}

		}
		throw new Exception("No double");
	}

}
