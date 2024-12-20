package com.testing;

import java.util.Arrays;
import java.util.Collections;

public class Solution {

	public static void main(String[] args) {

		String s = "bb";
		String t = "ahbgdc";

		System.out.println(isSubsequence(s, t));
	}

	public static boolean isSubsequence(String s, String t) {

		int k = 0;
		int l = 0;
		int j = 0;
		while (k < s.length()) {
			if (t.indexOf(s.charAt(k)) != -1 && j < t.length()) {
				for (int i = j; i < t.length(); i++) {
					//System.out.println(s.charAt(k) + " == " + t.charAt(i) + " => " + (s.charAt(k) == t.charAt(i)));
					if (s.charAt(k) == t.charAt(i)) {
						j = i + 1;
						l++;
						break;
					}
				}
				k++;
			} else {
				return false;
			}
		}
		if (l == s.length()) {
			return true;
		}
		return false;
	}
}
