package com.sample;

public class Solution {

	public static void main(String[] args) {
		String s = "Test1ng-Leet=code-Q!";
		//"Qedo1ct-eeLg=ntse-T!"
		System.out.println(reverseOnlyLetters(s));
	}

	public static String reverseOnlyLetters(String s) {
		int left = 0, right = s.length() - 1;
		char[] charArr = s.toCharArray();
		while (left < right) {
			if (!Character.isAlphabetic(charArr[left])) {
				left++;
			} else if (!Character.isAlphabetic(charArr[right])) {
				right--;
			} else {
				// Swap characters
				char temp = charArr[left];
				charArr[left] = charArr[right];
				charArr[right] = temp;
				// Move pointers
				left++;
				right--;
			}
		}
		return new String(charArr);
	}
}
