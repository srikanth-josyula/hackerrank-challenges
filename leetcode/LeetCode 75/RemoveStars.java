package com.testing;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {

		String s = "leet**cod*e";

		System.out.println(removeStars(s));
	}

	public static String removeStars(String s) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*') {
				stack.pop(); // remove last element
			} else {
				stack.push(s.charAt(i)); // add element
			}
		}

		char[] ansArr = new char[stack.size()];
		int ansIndex = stack.size() - 1;

		while (!stack.isEmpty())
			ansArr[ansIndex--] = stack.pop();

		return new String(ansArr);
	}
}
