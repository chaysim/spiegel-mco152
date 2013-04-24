package spiegel.regex;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PhoneNumberVerifierTest {

	@Test
	public void testVerify() {

		assertTrue(PhoneNumberVerifier.verify("17182234567"));
		assertTrue(PhoneNumberVerifier.verify("1 7182234567"));
		assertTrue(PhoneNumberVerifier.verify("1 718 223 4567"));
		assertTrue(PhoneNumberVerifier.verify("7182234567"));
		assertTrue(PhoneNumberVerifier.verify("2234567"));
		assertTrue(PhoneNumberVerifier.verify("2234567"));
		assertFalse(PhoneNumberVerifier.verify("123"));
		assertTrue(PhoneNumberVerifier.verify("1-718-234-5689"));

	}

}
