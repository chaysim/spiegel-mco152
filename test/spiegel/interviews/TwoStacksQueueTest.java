package spiegel.interviews;

import java.util.Stack;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import spiegel.interviews.TwoStacksQueue;

public class TwoStacksQueueTest {

	private TwoStacksQueue<String> tOne;

	@Before
	public void setUp() throws Exception {
		String[] letters = { "d", "b", "a" };
		Stack<String> letter = new Stack<String>();
		for (int i = 0; i < letters.length; i++) {
			letter.push(letters[i]);
		}
		tOne = new TwoStacksQueue<String>(letter);
	}

	@Test
	public void test() {
		String one = tOne.dequeue();
		Assert.assertEquals(one, "d");
		tOne.enqueue("f");
		Assert.assertEquals(tOne.peek(), "b");
	}

}
