package com.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {

		String text = "gotxxotgxdogt", word = "got";

		// Words “got,” “otg” and “ogt” are anagrams of “got.”
		System.out.println(anagramOccurrences(text, word));
	}

	// https://builtin.com/data-science/sliding-window-algorithm
	public static int anagramOccurrences(String text, String word) {

		int totalAnagramCount = 0;

		List<String> list = new ArrayList<String>();

		StringBuilder sb = new StringBuilder(text.substring(0, word.length() - 1));

		int windowSize = word.length();
		char[] textArr = text.toCharArray();

		int start = 0;

		for (int i = word.length() - 1; i < textArr.length; i++) {
			sb.append(textArr[i]);
			list.add(sb.toString());

			if (isAnagram(sb.toString(), word)) {
				totalAnagramCount++;
			}
			if ((i - start + 1) == windowSize) {
				sb.deleteCharAt(0);
				start += 1;
			}
		}

		System.out.println(list);
		return totalAnagramCount;
	}

	public static boolean isAnagram(String str, String word) {
		char[] s1Array = str.toCharArray();
		char[] s2Array = word.toCharArray();
		Arrays.sort(s1Array);
		Arrays.sort(s2Array);
		return Arrays.equals(s1Array, s2Array);
	}

}
