package com.testing;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

		int n = 19;

		System.out.println(isHappy(n));
	}

	public static boolean isHappy(int n) {

		Set<Integer> seen = new HashSet<Integer>();
		
		while(n != 1 && !seen.contains(n)) {
			seen.add(n);
			n = getSum(n);
		}
		
		return n == 1;
	}

	public static int getSum(int n) {
		int sum = 0;
		for (char c : String.valueOf(n).toCharArray()) {
			sum += (Character.getNumericValue(c) * Character.getNumericValue(c));
		}
		return sum;
	}
}
