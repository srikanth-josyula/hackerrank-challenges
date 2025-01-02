package com.testing;

public class Solution {

	public static void main(String[] args) {

		String str1 = "abcde";
		String str2 = "abfge";

		System.out.println(longestCommonString(str1, str2));
	}

	public static String longestCommonString(String str1, String str2) {

		String out = "";
		int k = str1.length();
		int i = 0;

		while (i < k) {
			for (int j = i + 1; j <= str1.length(); j++) {
				if (str2.contains(str1.substring(i, j))) {
					if (out.length() < str1.substring(i, j).length()) {
						out = str1.substring(i, j);
					}
				}
			}
			i++;
		}
		return out;
	}
}
