package com.sample;

public class Solution {

	public static void main(String[] args) {

		String s = "the sky is blue";
		System.out.println(reverseWords(s));
	}

	public static String reverseWords(String s) {

		StringBuilder sb = new StringBuilder();
		String[] split = s.split(" ");
		
		for (int i = split.length - 1; i >= 0; i--) {
	        sb.append(split[i]);
	        if (i != 0) {
	            sb.append(" ");
	        }
	    }
		return sb.toString();
	}
}
