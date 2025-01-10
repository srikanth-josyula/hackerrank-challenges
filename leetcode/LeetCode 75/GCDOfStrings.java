package com.testing;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

		// String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX", str2 =
		// "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";

		String str1 = "ABABABAB", str2 = "ABAB";

		System.out.println(gcdOfStrings(str1, str2));
	}

	public static String gcdOfStrings(String str1, String str2) {

		//VERY BAD 15ms
		String resp = "";

		Set<String> set = new HashSet<>();

		for (int i = 1; i <= str1.length(); i++) {
			if (str1.replace(str1.substring(0, i), "").isEmpty()) {
				set.add(str1.substring(0, i));
			}
		}
		for (int i = 1; i <= str2.length(); i++) {
			if (str2.replace(str2.substring(0, i), "").isEmpty() && set.contains(str2.substring(0, i))
					&& str2.substring(0, i).length() > resp.length()) {
				resp = str2.substring(0, i);
			}
		}

		return resp;
	}
}
