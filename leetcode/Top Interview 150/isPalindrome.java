package com.testing;

public class Solution {

	public static void main(String[] args) {

		int k = 121;

		System.out.println(isPalindrome(k));
	}

	public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false; // Negative numbers are not palindromes
        }

        int original = x;
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return original == reversed;
    }
}
