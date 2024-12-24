package com.sample;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		String num = "1210";

		System.out.println(digitCount(num));
	}

	public static boolean digitCount(String num) {
		
		//Input: num = "1210"
		//Output: true
		//i= 0 =>  0 occurs num[0] i.e. 1 times in num => true
		//i= 1 =>  1 occurs num[1] i.e. 2 times in num => true
		//i= 2 =>  2 occurs num[2] i.e. 1 times in num => true
		//i= 3 =>  3 occurs num[3] i.e. 0 times in num => true
		//The condition holds true for every index in "1210", so return true.
		
		StringBuilder sb = new StringBuilder(num.length());
		
		
		for(int i=0; i < num.length(); i++) {
			sb.append(num.length() - num.replace(String.valueOf(i), "").length());
		}
		
		if((sb.toString()).equals(num)) {
			return true;
		}else {
			return false;
		}
	}
}
