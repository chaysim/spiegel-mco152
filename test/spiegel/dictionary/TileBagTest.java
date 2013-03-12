package spiegel.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

public class TileBagTest {

	@Test
	public void testFillbag() {
		TileBag tb = new TileBag();
		assertEquals(144, tb.getLetters().size());
	}

	@Test
	public void testGetSomeLetters() {
		TileBag tb = new TileBag();
		assertEquals(144, tb.getLetters().size());
		System.out.println(tb.getSomeLetters(27));
		System.out.println(tb.getLetters());
		assertEquals(117, tb.getLetters().size());
	}
}
