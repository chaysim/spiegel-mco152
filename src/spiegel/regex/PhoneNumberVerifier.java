package spiegel.regex;

import java.util.regex.Pattern;

public class PhoneNumberVerifier {
	public static final String REGEX = "((1[- ]?)?([2-9][0-9]{2}[- ]?))?[2-9][0-9]{2}[- ]?[0-9]{4}";
	public static final Pattern pattern = Pattern.compile(REGEX);

	public static boolean verify(String phoneNumber) {

		return pattern.matcher(phoneNumber).matches();
	}
}
