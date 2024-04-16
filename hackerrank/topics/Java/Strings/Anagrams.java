package com.java.hackerrank.dashboard.strings;

//import java.util.Arrays;
import java.util.Scanner;

/**
 * Two strings, and , are called anagrams if they contain all the same
 * characters in the same frequencies. For example, the anagrams of CAT are CAT,
 * ACT, TAC, TCA, ATC, and CTA.
 **/
public class Anagrams {

	static boolean isAnagram(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		} else {
			for (int i = 0; i < a.length(); i++) {
				char ch = a.toLowerCase().charAt(i);
				b = b.toLowerCase();
				// Dont know
				if (b.indexOf(ch) != -1) {
					b = b.replaceFirst(ch + "", "");
				} else {
					return false;
				}
			}
			return b.length() == 0;
		}
		
		// USING ARRAYS
		/*boolean flag = false;
		char[] str1 = "CAT".toCharArray();
		char[] str2 = "ACT".toCharArray();

		if (str1.length != str2.length)
			return flag;

		Arrays.sort(str1);
		Arrays.sort(str2);

		for (int i = 0; i < str1.length; i++) {
			System.out.println(str1[i] + " " + str2[i]);
			if (str1[i] != str2[i]) {
				return flag;
			}
		}
		return flag;*/
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");
	}
}
