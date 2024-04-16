package com.java.hackerrank.dashboard.strings;

import java.util.Scanner;

/**
 * A palindrome is a word, phrase, number, or other sequence of characters which
 * reads the same backward or forward.(Wikipedia)
 * 
 * Sample Input madam
 * 
 * Sample Output Yes
 **/
public class StringReverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entry = sc.next();
		String temp = "";

		int count = entry.toCharArray().length;
		for (int i = (count - 1); i >= 0; i--) {
			temp += entry.charAt(i);
		}

		if (entry.equals(temp)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		sc.close();
	}

}
