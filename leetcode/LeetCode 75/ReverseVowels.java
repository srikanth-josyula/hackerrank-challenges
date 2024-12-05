package com.sample;

import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {

		String s = "IceCreAm";

		System.out.println(reverseVowels(s));
	}

	public static String reverseVowels(String s) {
		StringBuilder sb = new StringBuilder(s);
		int l = 0;
		int r = s.length() - 1;

		while (l < r) {
			while (l < r && !isVowel(sb.charAt(l)))
				++l;
			while (l < r && !isVowel(sb.charAt(r)))
				--r;
			sb.setCharAt(l, s.charAt(r));
			sb.setCharAt(r, s.charAt(l));
			++l;
			--r;
		}

		return sb.toString();
	}

	private static boolean isVowel(char c) {
		return Arrays.asList('A','E','I','O','U','a','e','i','o','u').contains(c);
	}
}
