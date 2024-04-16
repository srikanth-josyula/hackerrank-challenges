package com.java.hackerrank.dashboard.strings;

import java.util.Scanner;

/**
 * Input Format
 * 
 * The first line contains a string denoting s. 
 * The second line contains an integer denoting k.
 * 
 * Output Format
 * 
 * Return the respective lexicographically smallest and largest substrings as a single newline-separated string.
 **/

public class SubstringComparision {

	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";
		
		smallest = s.substring(0, k);
		largest = s.substring(0, k);
		
		// "Compare to" method doesn't turn just the equel case it also turns a value.
		for (int i = 0; i <= s.length() - k; i++) {
			String str = s.substring(i, k + i);
			if (smallest.compareTo(str) > 0) {
				smallest = str;
			}
			if (largest.compareTo(str) < 0) {
				largest = str;
			}
		}
		return smallest + "\n" + largest;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int k = scan.nextInt();
		scan.close();

		System.out.println(getSmallestAndLargest(s, k));
	}
}
