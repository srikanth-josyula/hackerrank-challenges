package com.java.hackerrank.dashboard.strings;

import java.util.Scanner;

/**
 * Input Format
 * 
 * The first line contains a string A. The second line contains another string
 * B. The strings are comprised of only lowercase English letters.
 * 
 * Output Format
 * 
 * There are three lines of output: For the first line, sum the lengths of A and
 * B. For the second line, write Yes if A is lexicographically greater than B
 * otherwise print No instead. For the third line, capitalize the first letter
 * in both and and print them on a single line, separated by a space.
 * 
 * Explanation 0
 * 
 * String is A "hello" and is B "java".
 * 
 * A has a length of 5, and B has a length of 4; the sum of their lengths is 9. 
 * When sorted alphabetically/lexicographically, "hello" precedes "java"; therefore,
 * A is not greater than B and the answer is No.
 * 
 * When you capitalize the first letter of both A and B and then print them
 * separated by a space, you get "Hello Java".
 * 
 **/
public class StringsIntroduction {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		System.out.println(A.length() + B.length());
		int l = A.length() > B.length() ? B.length() : A.length();
		String str = "";
		for (int i = 0; i < l; i++) {
			if ((int) (A.toLowerCase()).charAt(i) > (int) (B.toLowerCase()).charAt(i)) {
				str = "Yes";
				break;
			} else if ((A.toLowerCase()).charAt(i) < (B.toLowerCase()).charAt(i)) {
				str = "No";
				break;
			}
		}
		if (str == "") {
			if (A.length() > B.length()) {
				str = "Yes";
			} else {
				str = "No";
			}
		}
		System.out.println(str);

		System.out.println((A.toUpperCase()).charAt(0) + A.substring(1, A.length()) + " " + (B.toUpperCase()).charAt(0)
				+ B.substring(1, B.length()));
		sc.close();
	}
}
