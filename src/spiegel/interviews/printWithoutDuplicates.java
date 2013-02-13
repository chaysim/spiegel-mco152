package spiegel.interviews;

import java.util.HashMap;

public class printWithoutDuplicates {

	private String[] unsorted;

	public printWithoutDuplicates(String[] unsorted) {
	
		this.setUnsorted(unsorted);
	}
	
	public String[] getSorted()
	{
		String[] sorted = new String[unsorted.length];
		//if it was a student you would do integer, student
		HashMap<String, String> hashMap = new HashMap<String, String>();
		for(int i = 0; i < unsorted.length; i++)
		{
			if(!hashMap.containsKey(unsorted[i]))
			hashMap.put(unsorted[i], unsorted[i]);
		}
		return sorted;
		
	}

	public String[] getUnsorted() {
		return unsorted;
	}

	public void setUnsorted(String[] unsorted) {
		this.unsorted = unsorted;
	}

}
