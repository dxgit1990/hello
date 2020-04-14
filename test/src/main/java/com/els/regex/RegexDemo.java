package com.els.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
	public static void main(String[] args) {
		getResult("z?");
//		getNewResult("z?");
	}

	private static void getResult(String string) {
		Pattern compile = Pattern.compile("[A-Za-z]{1,3}\\?{1,3}");
		Matcher matcher = compile.matcher(string);
		System.err.println(matcher.matches());
	}
}
