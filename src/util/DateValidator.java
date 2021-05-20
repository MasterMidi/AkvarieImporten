package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator {

	public static boolean validateDate(String date) {
		Pattern pattern = Pattern.compile("^(19|20)\\d\\d([-])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])$");
		Matcher matcher = pattern.matcher(date);
		return matcher.find();
	}
}
