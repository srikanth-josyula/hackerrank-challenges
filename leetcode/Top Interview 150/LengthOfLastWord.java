package com.sample;

public class Solution {

	public static void main(String[] args) {

		String s = "   fly me   to   the moon      ";
		System.out.println(lengthOfLastWord(s));
	}

	public static int lengthOfLastWord(String s) {
		
		String[] split = s.split(" ");
        return split[split.length - 1].length();
	}
}
