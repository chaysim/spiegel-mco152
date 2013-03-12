package spiegel.interviews;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class FindDoubleTest {
	private FindDouble fd; 
	private FindDouble fd2; 
	@Before
	public void setUp() throws Exception {
		int[] array = {1,2,3,4,4,5,6,7,8,9,10,11,12,13,14};
		int[] array2 = {5,6,7,8,9,10,11,12,12,13,14};
		fd = new FindDouble(array);
		fd2 = new FindDouble(array2);
	}
	
	@Test
	public void test() throws Exception {
		assertEquals(fd.getDouble(), 4);
		assertNotSame(fd.getDouble(), 3);
	}
	@Test
	public void test2() throws Exception {
		assertEquals(fd2.getDouble(), 12);
		assertNotSame(fd2.getDouble(), 7);
	}
}
