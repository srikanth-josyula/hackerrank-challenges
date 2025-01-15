package com.testing;

public class Solution {

	public static void main(String[] args) {

		String s = "A man, a plan, a canal: Panama";

		System.out.println(isPalindrome(s));
	}

	public static boolean isPalindrome(String s) {

		
		// Used 7Ms
		if (s == "" || s == null) {
			return true;
		}

		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();

		for (int i = s.length() - 1; i >= 0; i--) {
			if (Character.isLetterOrDigit(s.charAt(i))) {
				sb.append(Character.toLowerCase(s.charAt(i)));
			}
			if (Character.isLetterOrDigit(s.charAt((s.length() - 1) - i))) {
				sb1.append(Character.toLowerCase(s.charAt((s.length() - 1) - i)));
			}
		}

		if (sb.compareTo(sb1) == 0) {
			return true;
		} else {
			return false;
		}
		
		// In 14ms
		/*if (!s.isEmpty()) {
			s = s.replaceAll("[^a-zA-Z0-9]", "").trim();

			if(s.equalsIgnoreCase(new StringBuilder(s).reverse().toString())) {
				return true;
			}else {
				return false;
			}
		} else {
			return true;
		}*/
	}
}
